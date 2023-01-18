package se.JensenYH.Java.SaltMerch.backendProject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public  class CartRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    // todo: this method needs you to write its SQL query

    public List<CartItem> selectAllItems(){
        //Done1
        // todo: write the SQL query for getting all columns and rows from the cart_items table
        var sql = "SELECT * FROM cart_items";// <<<< todo: WRITE SQL QUERY HERE

        RowMapper<CartItem> rm = (rs, rowNum) -> new CartItem(
                rs.getInt("product_id"),
                rs.getString("title"),
                rs.getString("color"),
                rs.getString("size"),
                rs.getString("preview_image"),
                rs.getInt("quantity"));
        // NOTE: you can leave everything else here as it is
        return jdbcTemplate.query(sql,rm);
    }



        // NOTE: NO NEED TO MODIFY THIS METHOD!
    /** Inserts a new item to the cart, or increments to quantity of the item if it's
     *   already in the cart, and it lowers the stock of that item at the same time. */
    public int insertOrIncrementItem(CartItem item) {
        // lower stock once cart item is added
        var lowerStockSql = """
                UPDATE sizes
                SET stock = stock - 1
                WHERE id = (
                    SELECT s.id FROM sizes AS s
                    INNER JOIN variants AS v
                    ON v.id = s.variant_id
                    WHERE product_id = (:pid) AND color_name = (:color) AND size = (:size));
                """;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pid", item.productId);
        paramMap.put("size", item.size);
        paramMap.put("color", item.color);
        
        int curQty = itemQuantity(item);
        System.out.println("curQty = " + curQty);
        String sql = "";
        if (curQty < 0) {
            // insert item with quantity 1
            sql = """
                    INSERT INTO cart_items (product_id, title, color, size, quantity, preview_image)
                    VALUES ((:pid), (:title), (:color), (:size), 1, (:img));
                    """ + lowerStockSql;
            paramMap.put("title", item.title);
            paramMap.put("img", item.previewImage);
        }
        else if (curQty == 0)
            return -2; // edge case, item in cart has qty 0
        else {
            // increment quantity
            sql = """
                        UPDATE cart_items
                        SET quantity = quantity + 1
                        WHERE product_id = (:pid) AND color = (:color) AND size = (:size);
                    """ + lowerStockSql;
        }
        return new NamedParameterJdbcTemplate(jdbcTemplate).update(sql, paramMap);
    }
    
    // NOTE: NO NEED TO MODIFY THIS METHOD!
    /** Deletes an item from the cart if its quantity was 1, or decrements its
     *   quantity if it's more than 1, and it restocks the item at the same time. */
    public int deleteOrDecrementItem(CartItem item) {
        // restock once cart item is removed
        var restockSql = """
                UPDATE sizes
                SET stock = stock + 1
                WHERE id = (
                    SELECT s.id FROM sizes AS s
                    INNER JOIN variants AS v
                    ON v.id = s.variant_id
                    WHERE product_id = (:pid) AND color_name = (:color) AND size = (:size));
                """;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pid", item.productId);
        paramMap.put("size", item.size);
        paramMap.put("color", item.color);
        
        int curQty = itemQuantity(item);
        String sql;
        if (curQty < 0) {
            return -2;
        }
        else if (curQty < 2) {
            // delete the item
            sql = """
                    DELETE FROM cart_items
                    WHERE product_id = (:pid) AND color = (:color) AND size = (:size);
                    """ + restockSql;
        }
        else {
            // decrement quantity
            sql = """
                    UPDATE cart_items
                    SET quantity = quantity - 1
                    WHERE product_id = (:pid) AND color = (:color) AND size = (:size);
                    """ + restockSql;
        }
        return new NamedParameterJdbcTemplate(jdbcTemplate).update(sql, paramMap);
    }
    
    /** Deletes all items from the cart; IF the restock param is true, it restocks
     *   all items that were previously in the cart. Otherwise it doesn't restock
     *   anything, meaning the items were sold. */
    @Transactional
    public void deleteAllItems(boolean restock) {
        // clearing the cart should either do nothing else (IF buyout),
        //  or restock all amounts (IF just clearing the cart)
        List<CartItem> cartItems = selectAllItems();
        for (CartItem item : cartItems) {
            var sql = """
                    DELETE FROM cart_items
                    WHERE product_id = (:pid) AND size = (:size) AND color = (:color);
                    """ + (restock ? """
                    UPDATE sizes
                    SET stock = stock + (:qty)
                    WHERE id = (
                    	SELECT s.id FROM sizes AS s
                    	INNER JOIN variants AS v
                    	ON v.id = s.variant_id
                    	WHERE product_id = (:pid) AND size = (:size) AND color_name = (:color));
                    """ : "");
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("pid", item.productId);
            paramMap.put("size", item.size);
            paramMap.put("color", item.color);
            paramMap.put("quantity", item.quantity);
            int res = new NamedParameterJdbcTemplate(jdbcTemplate).update(sql, paramMap);
            System.out.println("res = " + res);
        }
    }
    
    // NOTE: NO NEED TO MODIFY THIS METHOD!
    private int itemQuantity(CartItem item) {
        RowMapper<Integer> rm = (rs, rowNum) -> rs.getInt("quantity");
        var sql = """
                SELECT quantity
                FROM cart_items
                WHERE product_id = ? AND color = ? AND size = ?
                """;
        List<Integer> quantityList = jdbcTemplate.query(sql, rm, item.productId,
                                                          item.color, item.size);
        return quantityList.size() > 0 ? quantityList.get(0) : -10;
    }
}
