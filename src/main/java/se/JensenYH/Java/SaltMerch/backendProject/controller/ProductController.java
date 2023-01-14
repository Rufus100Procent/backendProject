package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    @GetMapping("/products/{category}")
    public ResponseEntity<List<Product>> getAllProductsCategory(@PathVariable ("category") String catagory){

        List<Product> products = productService.selectAll(catagory);

        return ResponseEntity.ok(products);
    }


    //endpoint done
    @GetMapping("/products/{id}")
    public Product getAllProductsCategory(@PathVariable int id){

      Object aa =  productService.selectAll(String.valueOf(id));

        return (Product) aa;
    }



    // done
    @PostMapping("/Prodocts/{catagory}")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product prod, @PathVariable("catagory") String catagory){

       Object obj =  productService.updateProductMeta(Integer.parseInt(catagory), prod);

        return new ResponseEntity<>((Product) obj, HttpStatus.CREATED);
    }



    //done
    @PostMapping("/products/{id}/product/{id2}")
    public ResponseEntity createNewVariantForSpecificProduct (@PathVariable int  id,
                                                    @PathVariable ("id2") int id2,
                                                    @RequestBody Product product) {

       return ResponseEntity.ok().body(id + "" + id2 +"" + product);
    }

    @PutMapping("/products/{id}")
    public Product specificSizeOfVariant(@PathVariable int id){

        return new Product();
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
