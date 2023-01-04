package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.model.Product;



@RequestMapping("/api/v1")
@RestController
public class ProductController {
    @GetMapping("/products")
    public Product getAllProducts(){

        Product product;
        return new Product(1, "7", "producttest", "this is testing i repeat", "none");

    }

    @GetMapping("/getAllProductsCategory")
    public void getAllProductsCategory(){

    }

    @GetMapping("/getOneSpecificProduct")
    public void getOneSpecificProduct(){

    }

    @PostMapping("/createNewProduct")
    public void createNewProduct(){

    }

    @PutMapping("/updateProductMetaData")
    public void updateProductMetaData(){

    }

    @PostMapping("/createNewVariantForSpecificProduct")
    public void createNewVariantForSpecificProduct(){

    }

    @PostMapping("specificSizeOfVariant")
    public void specificSizeOfVariant(){

    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(){

    }

    @DeleteMapping("/deleteVariantOfProduct")
    public void deleteVariantOfProduct(){

    }

}
