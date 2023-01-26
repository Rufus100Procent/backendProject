package se.JensenYH.Java.SaltMerch.backendProject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import se.JensenYH.Java.SaltMerch.backendProject.Model.ColorVariant;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.Model.SizeContainer;
import se.JensenYH.Java.SaltMerch.backendProject.Model.VariantWImages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    /** Only calls selectAll(String category) with a null category;
     * Useful for reading ALL products, regardless of category. */
    public List<Product> selectAll()
    {
        return selectAll(null);
    }

    /** Reads all rows from the products table and returns them as a List of Products. */
    public List<Product> selectAll(String category)
    {
        String sql = "SELECT * FROM products";

        if (category != null) sql += " WHERE category = (:category)";
        RowMapper<Product> rm = (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("category"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("preview_image"));
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", category);
        return new NamedParameterJdbcTemplate(jdbcTemplate).query(sql, paramMap, rm);
    }

    /** Inserts a new product in the database, together with its
     *      variants, including images and sizes. It takes a
     *      Product parameter containing everything. */
    public Product insertProductAndProps(Product prod, String category) {
        var sql = """
                INSERT INTO products (category, title, description, preview_image)
                VALUES (?, ?, ?, ?) RETURNING id;""";
        RowMapper<Integer> rm = (rs, rowNum) -> rs.getInt("id");
        List<Integer> pids = jdbcTemplate.query(sql, rm, category, prod.getTitle(),
                prod.getDescription(), prod.getPreviewImage());
        int pid = pids.size() > 0 ? pids.get(0) : -1;

        Product newProd = null;
        if (pid > -1) {
            newProd = new Product();
            newProd.setId(pid);
            newProd.setCategory(category);
            newProd.setTitle(prod.getTitle());
            newProd.setDescription(prod.getDescription());
            newProd.setPreviewImage(prod.getTitle());

            for (ColorVariant v : prod.getColorVariants()) {
                ColorVariant newv = new ColorVariant();
                RowMapper<Integer> rmv = (rs, rowNum) -> rs.getInt("id");
                var sqlv = """
                        INSERT INTO variants (color_name, product_id) VALUES (?, ?) RETURNING id;""";
                List<Integer> vids = jdbcTemplate.query(sqlv, rmv, v.getColorName(), pid);
                int vid = vids.size() > 0 ? vids.get(0) : -1;

                if (vid > -1) {
                    newv.setColorName(v.getColorName());

                    for (String url : v.getImages()) {
                        var sqli = """
                                INSERT INTO images (url, variant_id) VALUES (?, ?);""";
                        int ires = jdbcTemplate.update(sqli, url, vid);
                        if (ires == 1)
                            newv.getImages().add(url);
                    }
                    for (SizeContainer s : v.getSizes()) {
                        var sqls = """
                                INSERT INTO sizes (size, stock, variant_id) VALUES (?, ?, ?);""";
                        int sres = jdbcTemplate.update(sqls, s.getSize(), s.getStock(), vid);
                        if (sres == 1)
                            newv.getSizes().add(s);
                    }
                    newProd.getColorVariants().add(newv);
                }
            }
        }
        return newProd;
    }


    /** Updates a specific row in the products table
     *  (only its title, description, and preview_image). */
    public int updateProductMeta(int id, Product prod) {
        Product oldProd = getProductBase(id);
        if (oldProd == null)
            return -9;
        else {
            String title = prod.getTitle() != null && !prod.getTitle().isEmpty()
                    ? prod.getTitle() : oldProd.getTitle();
            String desc = prod.getDescription() != null && !prod.getDescription().isEmpty()
                    ? prod.getDescription() : oldProd.getDescription();
            String img = prod.getPreviewImage() != null && !prod.getPreviewImage().isEmpty()
                    ? prod.getPreviewImage() : oldProd.getPreviewImage();
            var sql = """
                    UPDATE products
                    SET title = ?, description = ?, preview_image = ?
                    WHERE id = ?;""";
            return jdbcTemplate.update(sql, title, desc, img, id);
        }
    }

    public int deleteProduct(int id) {
        var sql = """
                DELETE FROM products
                WHERE id = ?
                """;


        return jdbcTemplate.update(sql, id);
    }

    public Product getEntireProduct(int productId) {
        Product product = getProductBase(productId);
        if (product == null) {
            System.out.println("Product wasn't fetched from the db");
            return null;
        }
        List<VariantWImages> variantsWImages = getVariantsAndImages(productId);
        System.out.println("variantsWImages = " + variantsWImages);
        for (VariantWImages variantWImages : variantsWImages) {
            ColorVariant colorVariant = new ColorVariant();
            colorVariant.setColorName(variantWImages.getColorName());
            colorVariant.setSizes(getVariantSizes(variantWImages.getId()));
            try {
                colorVariant.setImagesFromCSV(variantWImages.getImagesCsv());
            }
            catch (Exception e) {
                colorVariant.setImages( new ArrayList<>());
                System.out.println("Exception parsing images from csv; see stack trace");
                e.printStackTrace();
            }
            product.getColorVariants().add(colorVariant);
        }

        return product;
    }

    /** Utility method used in getEntireProduct().
     *      Reads rows from variants and images tables. */
    public List<VariantWImages> getVariantsAndImages(int productId) {
        var sql = """
                SELECT v.id AS v_id, v.color_name,
                	STRING_AGG(url, ',') images
                FROM variants AS v
                LEFT OUTER JOIN images AS i1
                ON v.id = i1.variant_id
                WHERE v.product_id = ?
                GROUP BY v_id, v.color_name
                """;
        RowMapper<VariantWImages> rm = (rs, rowNum) -> new VariantWImages(
                rs.getInt("v_id"),
                rs.getString("color_name"),
                rs.getString("images"));
        return jdbcTemplate.query(sql, rm, productId);
    }

    /** Utility method used in getEntireProduct().
     *      Reads a row from sizes table. */
    public List<SizeContainer> getVariantSizes(int variantId) {
        var sql = """
                SELECT size, stock
                FROM variants v
                INNER JOIN sizes AS s
                ON v.id = s.variant_id
                WHERE v.id = ?
                """;
        RowMapper<SizeContainer> rm = (rs, rowNum) -> new SizeContainer(
                rs.getString("size"),
                rs.getInt("stock"));
        return jdbcTemplate.query(sql, rm, variantId);
    }

    /** Inserts rows into variants, images, and sizes,
     * thus creating a new variant for a specific product. */
    public ColorVariant addVariant(int productId, ColorVariant colorVariant) {
        System.out.println("colorVariant.colorName = " + colorVariant.getColorName());
        ColorVariant newv = new ColorVariant();
        RowMapper<Integer> rmv = (rs, rowNum) -> rs.getInt("id");
        var sqlv = """
                INSERT INTO variants (color_name, product_id) VALUES (?, ?) RETURNING id;""";
        List<Integer> vids = jdbcTemplate.query(sqlv, rmv, colorVariant.getColorName(), productId);
        int vid = vids.size() > 0 ? vids.get(0) : -1;

        if (vid > -1) {
            newv.setColorName(colorVariant.getColorName());

            for (String url : colorVariant.getImages()) {
                var sqli = "INSERT INTO images (url, variant_id) VALUES (?, ?);";
                int ires = jdbcTemplate.update(sqli, url, vid);
                if (ires == 1)
                    newv.getImages().add(url);
            }
            for (SizeContainer s : colorVariant.getSizes()) {
                var sqls = "INSERT INTO sizes (size, stock, variant_id) VALUES (?, ?, ?);";
                int sres = jdbcTemplate.update(sqls, s.getSize(), s.getStock(), vid);
                if (sres == 1)
                    newv.getSizes().add(s);
            }
        }
        return newv;
    }


    /** Delete a specific row from variants. */
    public int deleteVariant(int productId, String color) {
        var sql = "DELETE FROM variants WHERE id = ? AND color_name = ?";
        return jdbcTemplate.update(sql, productId, color);
    }


    /** Restocks a specific product variant, i.e.
     *      adds a certain number to its stock. */
    public int restockSize(int productId, String size, String color, int qty) {
        var sql = """
                UPDATE sizes SET stock = stock + ?
                WHERE id = (
                    SELECT s.id FROM sizes AS s
                    INNER JOIN variants AS v
                    ON v.id = s.variant_id
                    WHERE product_id = ? AND size = ? AND color_name = ?);""";
        return jdbcTemplate.update(sql, qty, productId, size, color);
    }


    /** Utility function used in other methods.
     *      Only reads a product's metadata. */
    private Product getProductBase(int productId) {
        RowMapper<Product> rm = (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("category"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("preview_image"));
        var sql = "SELECT * FROM products WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, rm, productId);
        return products.size() > 0 ? products.get(0) : null;
    }
}
