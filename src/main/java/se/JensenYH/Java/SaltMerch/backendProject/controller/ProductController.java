package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;


@RequestMapping("/api/v1")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Product getAllProducts(){

       productService.selectAll();

        return null;
    }

    @GetMapping("/getAllProductsCategory")
    public void getAllProductsCategory( @PathVariable String category){

        productService.selectAll();
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
