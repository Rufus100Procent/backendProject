package se.JensenYH.Java.SaltMerch.backendProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3010")
@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;

    //done
    @GetMapping("/selectall")
    public Object selectAllIteams(CartItem item){

        return cartService.selectAllItems();
    }


    //Almost done
    @GetMapping("/cartss/{id}")

    public ResponseEntity<List<CartItem>> addIteamToTheCart(@PathVariable  int id) {

        return new ResponseEntity<>(cartService.selectAllItems() , HttpStatus.OK);
    }

    //almost done
    @DeleteMapping ("/iteam/{id}")
    ////PATCH /api/v1/carts/{id}?action=add
    //PATCH /api/v1/carts/{id}?action=remove
    public ResponseEntity<?>  removeIteamFromCart(@PathVariable CartItem id ) {


       if (cartService.deleteOrDecrementItem(id) >= 0){
           return ResponseEntity.ok().build();
       }
        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/tt")
    public void deleteAllItems(){


    }

    @PutMapping("/carts/{id}")
    //DELETE /api/v1/carts/{id}
    //DELETE /api/v1/carts/{id}?buyout=true
    public ResponseEntity<?> reStockIteam(@PathVariable int id){
        return (ResponseEntity<?>) ResponseEntity.ok();
    }


}
