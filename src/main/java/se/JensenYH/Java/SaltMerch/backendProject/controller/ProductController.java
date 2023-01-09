package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import java.util.List;


@RequestMapping("/api/v2")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> productList = productService.selectAll();

        return ResponseEntity.ok(productList);

    }



    @GetMapping(value = "/testing")
    public ResponseEntity<List<Product>> ll(){
        List<Product> product = productService.selectAll();

        return ResponseEntity.status(555).body(product);
    }


    //endpoint done
    @GetMapping("/getAllProductsCategory{category}")
    public ResponseEntity<List<Product>> getAllProductsCategory(@PathVariable String category){

        List<Product> product  = productService.selectAll(category);

        return ResponseEntity.ok(product);
    }

    //endpoint done
    @GetMapping("/getOneSpecificProduct")
    public void getOneSpecificProduct(){


    }

    //endpoint done
    @PostMapping("/createNewProduct")
    public void createNewProduct(){

    }

    //endpoint done
    @PutMapping("/updateProductMetaData")
    public void updateProductMetaData(){

    }

    //endpoint done
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
