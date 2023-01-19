package se.JensenYH.Java.SaltMerch.backendProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.JensenYH.Java.SaltMerch.backendProject.Model.ColorVariant;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private List<Product> productList;

    //done
    public List<Product> selectAll(){
        return productRepository.selectAll();
    }

    //done
    public List<Product> selectAll(String category){

        if (category != null && !category.isEmpty()) {
            return productRepository.selectAll(category);
        }
        throw new RuntimeException("product with " + category + " doesnt exits");

    }


    public List<Product> selectAllOfCategory(String category){
        return productRepository.selectAllOfCategory(category);

    }

        public Product insertProductAndProps(Product prod, String category){
        return productRepository.insertProductAndProps(prod,category);
    }

    public int updateProductMeta(int id, Product prod) {

      return productRepository.updateProductMeta(id, prod);

    }

    public ColorVariant addvarient(int productId, ColorVariant colorVariant){
        return productRepository.addVariant(productId, colorVariant);
    }
    public Product getProductbse(int productId, Product product){
        return productRepository.getProductBase(productId);
    }

    public int deleteVariant(int productId, String color) {
        return productRepository.deleteVariant(productId, color);
    }


    public int deleteProduct(int id){
       return productRepository.deleteProduct(id);
    }

    public Product getEntireProduct(int productId){
        return productRepository.getEntireProduct(productId);
    }

    public int restockSize(int productId, String size, String color, int qty){
        return productRepository.restockSize(productId, size, color, qty);
    }

    private record VariantWImages(int id, String colorName, String imagesCsv) {}


}
