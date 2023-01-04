package se.JensenYH.Java.SaltMerch.backendProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.JensenYH.Java.SaltMerch.backendProject.model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> selectAll(){
        return productRepository.selectAll();
    }

    public List<Product> selectAll(String category){
        return productRepository.selectAll();
    }

    public List<Product> selectAllOfCategory(String category){
        return productRepository.selectAllOfCategory(category);
    }

    public Product insertProductAndProps(Product prod, String category){
        return productRepository.insertProductAndProps(prod,category);
    }


    public int updateProductMeta(int id, Product prod){
        return productRepository.updateProductMeta(id, prod);
    }

    public int deleteProduct(int id){
        return productRepository.deleteProduct(id);
    }

    public Product getEntireProduct(int productId){
        return productRepository.getEntireProduct(productId);
    }

    private record VariantWImages(int id, String colorName, String imagesCsv) {}


}
