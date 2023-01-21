package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.Model.ColorVariant;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import java.util.List;

/*
show all product in the database,
find a single product either by ID or name,
create new product,
update an existing product,
and delete existing product
 */
@CrossOrigin("http://localhost:3010")
@RequestMapping("/api/v1")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;


    //Working
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.selectAll();
    }

    //Tested
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    ///working
    @GetMapping("/products/{var}")
    public Object getAllProductsCategory(@PathVariable("var") String var) {
        switch (var) {
            case "hats":

            case "jackets":

            case "tshirt":

            case "bags":

                return productService.selectAll(var);

            default:
                return productService.getEntireProduct(Integer.parseInt(var));
        }

    }


    //working
    @PostMapping("/products/{catagory}")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product prod,
                                                    @PathVariable("catagory") String catagory) {

        Product obj = productService.insertProductAndProps(prod, catagory);

        if (catagory != null && !catagory.isEmpty()) {

            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } else {

            throw new RuntimeException("cant create " + catagory + " check your json");
        }

    }


    //working
    @PutMapping("/products/{id}")
    public ResponseEntity<Integer> specificSizeOfVariant(@PathVariable int id,
                                                         @RequestBody Product product) {

        int product1 = productService.updateProductMeta(id, product);


        return ResponseEntity.ok(product1);

    }

    //almost done??
    //violates not-null constraint, without the try catch
    @PostMapping("/products/{id}/variants")
    public ResponseEntity<String> createNewVariantForSpecificProduct(@PathVariable int id, ColorVariant colorVariant) {


        try {
            ColorVariant obj = productService.addvarient(id, colorVariant);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("100");
        }
        throw new RuntimeException("Error");

    }

    @PutMapping("/products/{id}/variants/stock/{size}/{color}/{quantity}")
    //////optional
    public void Restock(@PathVariable int id,
                        @RequestParam("stock") int size,
                        @PathVariable("color") int color,
                        @PathVariable("quantity") int quantity) {

        System.out.println("h");
    }

    //working
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {

        if (productService.deleteProduct(id) >= 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }


    @DeleteMapping("products/{productId}/variants/{variantId}")
    public ResponseEntity<String> deleteVariantOfProduct(@PathVariable("productId") Integer productId,
                                                         @PathVariable("variantId") Integer variantId) {
        int obj = productService.deleteVariant(productId, String.valueOf(variantId));

        switch (obj) {
            default:
            case 1:
                return ResponseEntity.ok().build();
            case 0:
                return ResponseEntity.badRequest().body("doesnt exist");
            case -1:
                return ResponseEntity.badRequest().body("cant delete what doesnt exist");
            case -2:
                return ResponseEntity.badRequest().body("cant delete what doesnt exist");

        }


    }

}
