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

    @GetMapping("/selectall")
    public List<CartItem> getCartContents() {
        return cartService.selectAllItems();
    }


    //Almost done
    @PatchMapping("/carts/{id}{action}")
    ///problem /Cannot convert value of type 'java.lang.String' to required type
    public ResponseEntity<Integer> removeOrAdd(@PathVariable int id,
                                               @RequestParam("action") CartItem action) {


        if (action.equals("remove")) {
            return ResponseEntity.ok(cartService.deleteOrDecrementItem(action));

        } else if (action.equals("add")) {
            return ResponseEntity.ok(cartService.insertOrIncrementItem(action));
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/carts/{id}{buyout}")
    //DELETE /api/v1/carts/{id}?buyout=true
    public void reStockIteam(@PathVariable long id,
                             @RequestParam("buyout") boolean buyout, CartItem item) {

        if (buyout) {
            cartService.deletAllIteams(buyout);
            System.out.println("completed");
        } else {
            cartService.deleteOrDecrementItem(item);
            System.out.println("test");
        }
    }
}
