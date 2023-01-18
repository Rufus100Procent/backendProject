package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import java.util.List;


@CrossOrigin("http://localhost:3010")
@RequestMapping("/api/v1")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;


    /////////////done
    //////working
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.selectAll();
    }


    /////// done
    ////// /products/hats
    ///// unkown problem
    @GetMapping("/products/{var}")
    public Object getAllProductsCategory(@PathVariable ("var") String var){
        switch (var){
            case "hats":

            case "jackets":

            case "tshirt":

            case "bags":

                return productService.selectAll(var);

            default:
                return productService.getEntireProduct(Integer.parseInt(var));
        }

    }

    /////// done
    //// /products/1
    /////need fixing
    ////there is collision
    /*@GetMapping("/products/{id}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable int id){

       Object obj =  productService.selectAll(String.valueOf(Integer.valueOf(id)));

       return ResponseEntity.ok((List<Product>) obj);
    }
*/


    //// done
    //// /products/hats
    ///// optional
    //working
    @PostMapping("/products/{catagory}")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product prod,
                                                    @PathVariable("catagory") String catagory){

       Product obj =  productService.insertProductAndProps(prod, catagory);

       if(catagory != null && !catagory.isEmpty() ){

           return new ResponseEntity<>(obj, HttpStatus.CREATED);
       } else {

           throw new RuntimeException("cant create " + catagory + " check your json");
       }

    }


    ///// done
    ///// /products/1
    ///working????????
    @PutMapping("/products/{id}")
    public ResponseEntity<Integer> specificSizeOfVariant(@PathVariable int id,
                                                         @RequestBody Product product){

        int product1 = productService.updateProductMeta(id, product);


        System.out.println(" " + id +  product);
        return ResponseEntity.ok(product1);

    }

    //done

    @PostMapping("/products/{id}/variants")
    public ResponseEntity createNewVariantForSpecificProduct (@PathVariable int id, Product product) {

       return null;
    }

    @PutMapping("/products/{id}/variants/stock?size={size}&color={green}&quantity={quantity}")
    //////optional
    public void Restock(@PathVariable int id,
                        @RequestParam ("stock") int size,
                        @PathVariable ("size") int s){

    }

    //done
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable("id") int id){

        int deletProduct = productService.deleteProduct(id);
        //returns 200
       return new ResponseEntity<>(deletProduct, HttpStatus.CREATED);
    }


    @DeleteMapping("products/{productId}/variants/{variantId}")
    public void deleteVariantOfProduct(){

    }

}
