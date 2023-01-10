package se.JensenYH.Java.SaltMerch.backendProject.controller;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.JensenYH.Java.SaltMerch.backendProject.model.CartItem;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;

    //done
    @GetMapping("/selectall")
    public Object selectAllIteams(){

        return cartService.selectAllItems();
    }


    //Almost done
    @PostMapping("/iteam")
    public ResponseEntity<Object> addIteamToTheCart(@RequestBody CartItem item) {

       Object d = cartService.insertOrIncrementItem(item);

        return ResponseEntity.ok().body(d + "" + item);

    }

    //almost done
    @DeleteMapping ("/iteam/{id}")
    public ResponseEntity<?>  removeIteamFromCart(@PathVariable CartItem id ) {


       if (cartService.deleteOrDecrementItem(id) >= 0){
           return ResponseEntity.ok().build();
       }
        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/tt")
    public void deleteAllItems(){


    }

    @PutMapping("//update/{id}")
    public ResponseEntity<?> reStockIteam(@PathVariable int id){
        return (ResponseEntity<?>) ResponseEntity.ok();
    }


}
