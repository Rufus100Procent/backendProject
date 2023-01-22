package se.JensenYH.Java.SaltMerch.backendProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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



    public List<Product> selectAll(){
        return productRepository.selectAll();
    }



    public Object selectAllOfCategory(String var){

        if (var != null && !var.isEmpty()) {
            switch (var) {
                case "hats":
                case "jackets":
                case "tshirt":
                case "bags":
                    return productRepository.selectAll(var);
                default:
                    return productRepository.getEntireProduct(Integer.parseInt(var));
            }
        }
        throw new RuntimeException("product with " + var + " doesnt exits");


    }
    public Product insertProductAndProps(Product prod, String category){

        if (category != null && !category.isEmpty()) {
            switch (category){
                case "hats":
                case "jackets":
                case "tshirt":
                case "bags":
                    return  productRepository.insertProductAndProps(prod, category);
            }
        }
            throw new RuntimeException("cant create " + category + " check your json");
    }

    public int updateProductMeta(int id, Product prod) {

      return productRepository.updateProductMeta(id, prod);

    }

    public ColorVariant addvarient(int productId, ColorVariant colorVariant){
        return productRepository.addVariant(productId, colorVariant);
    }
    public int deleteVariant(int productId, String color) {
        return productRepository.deleteVariant(productId, color);
    }

    public int deleteProduct(int id){
       return productRepository.deleteProduct(id);
    }

    public int restockSize(int productId, String size, String color, int qty){
        return productRepository.restockSize(productId, size, color, qty);
    }

}
