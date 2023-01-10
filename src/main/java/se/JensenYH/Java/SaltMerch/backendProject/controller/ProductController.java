package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import java.util.List;
import java.util.Map;


@RequestMapping("/api/v2")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    /////////////done
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.selectAll();

        return ResponseEntity.ok(productList);

    }


    //endpoint done
    @GetMapping("/productss/{id}")
    public ResponseEntity<Object> getAllProductsCategory(@PathVariable int id){

      Object aa =  productService.selectAll(String.valueOf(id));

        return ResponseEntity.ok(aa);
    }

    //done
    //products/1
    @GetMapping("/products/{id}")
    public ResponseEntity getOneSpecificProduct(@PathVariable int id){

        return ResponseEntity.ok(id);

    }


    // done
    //a/1
    @PostMapping("/a/{id}")
    public ResponseEntity<Object> createNewProduct(@RequestBody Product prod, @PathVariable int  id){

       Object obj =  productService.updateProductMeta(id, prod);

        return ResponseEntity.ok(obj  + " job is done");
    }

    //done
    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProductMetaData(@PathVariable int id, Product prod){

        Object o =   productService.updateProductMeta(id, prod);
        return ResponseEntity.ok(o);

    }


    //done
    @PostMapping("/product/{id}/product/{id2}")
    public ResponseEntity createNewVariantForSpecificProduct (@PathVariable int  id,
                                                    @PathVariable ("id2") int id2,
                                                    @RequestBody Product product) {

       return ResponseEntity.ok().body(id + "" + id2 +"" + product);
    }

    @PostMapping("specificSizeOfVariant")
    public void specificSizeOfVariant(){

    }


    //done
    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){

        return ResponseEntity.ok().body(id + "" + " has been deleted");
    }


    @DeleteMapping("/deleteVariantOfProduct")
    public void deleteVariantOfProduct(){

    }

}
