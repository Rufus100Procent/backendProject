package se.JensenYH.Java.SaltMerch.backendProject.controller;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.model.CartItem;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;
    @GetMapping("/selectall")
    public ResponseEntity<List<CartItem>> selectAllIteams(){

        List<CartItem> cartItemList = cartService.selectAllItems();

        if(cartItemList.isEmpty()){
            return ResponseEntity.ok().header("list is emty").body(cartItemList);
        }
        return new  ResponseEntity<>(cartItemList, HttpStatus.OK);
    }


    //Almost done
    @PostMapping("/iteam/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void  addIteamToTheCart(@RequestBody CartItem item) {

        cartService.insertOrIncrementItem(item);

    }

    //almost done
    @DeleteMapping ("/iteam/{delete}")
    public void  removeIteamFromCart(CartItem item) {
        cartService.deleteOrDecrementItem(item);
    }

    @DeleteMapping("/tt")
    public void clearCart(){

    }

    @PutMapping
    public void reStockIteam(){

    }


}
