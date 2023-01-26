package se.JensenYH.Java.SaltMerch.backendProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;

import java.util.List;

@CrossOrigin("http://localhost:3010")
@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;

    //working
    //Tested
    @GetMapping("/carts/{id}")
    public List<CartItem> getCartContents(@PathVariable int id) {
         return  cartService.selecttById(id);
    }

   //done
    //Tested
    @PatchMapping("/carts/{id}")
    public ResponseEntity<Integer> removeOrAdd(@PathVariable ("id") int id,
                                               @RequestParam("action") String action,
                                               @RequestBody CartItem item) {
        if ("remove".equals(action)) {
            return ResponseEntity.ok(cartService.removeIteam(item));

        } else if (action.equals("add")) {
            return ResponseEntity.ok(cartService.addIteam(item));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //working
    //Tested
    @DeleteMapping("/carts/{id}")
    public void reStockIteamOrClearCart(@PathVariable int id,
                             @RequestParam("buyout") boolean buyout) {

        if (buyout) {
            cartService.clearCart(true);
            System.out.println("completed");
        } else {
            cartService.restock(id);
            System.out.println("retock");
        }
    }
}
