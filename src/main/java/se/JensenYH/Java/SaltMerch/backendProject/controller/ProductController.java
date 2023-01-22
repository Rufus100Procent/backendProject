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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public ProductController() {
    }

    //Working
    //Tested
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.selectAll();
    }

    //Working
    //Tested
    @GetMapping("/products/{var}")
    public Object getAllProductsCategory(@PathVariable("var") String var) {
        return productService.selectAllOfCategory(var);
    }

    //Working
    //Tested
    @PostMapping("/products/{catagory}")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product prod,
                                                    @PathVariable("catagory") String catagory) {

        Product createProdect = productService.insertProductAndProps(prod, catagory);
        return ResponseEntity.ok(createProdect);
    }


    //Working
    //Tested
    @PutMapping("/products/{id}")
    public ResponseEntity<Integer> specificSizeOfVariant(@PathVariable int id,
                                                         @RequestBody Product product) {
        int product1 = productService.updateProductMeta(id, product);
        return ResponseEntity.ok(product1);
    }

    //almost done??
    @PostMapping("/products/{id}/variants")
    public ResponseEntity<String> createNewVariantForSpecificProduct(@PathVariable int id, ColorVariant colorVariant) {
            ColorVariant obj = productService.addvarient(id, colorVariant);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //working
    @PutMapping("/products/{id}/variants/stock{size}{color}{quantity}")
    //////optional
    public ResponseEntity<Integer> Restock(@PathVariable int id,
                        @RequestParam("size") String size,
                        @RequestParam("color") String color,
                        @RequestParam("quantity") int quantity) {

       int product = productService.restockSize(id,size,color,quantity);

       return ResponseEntity.ok(product);

    }

    //Working
    //Tested
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {

        if (productService.deleteProduct(id) >= 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }


    //working
    @DeleteMapping("products/{id}/variants{color}")
    public ResponseEntity<String> deleteVariantOfProduct(@PathVariable int id,
                                                         @RequestParam("color") String color) {
        int obj = productService.deleteVariant(id,color);
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
