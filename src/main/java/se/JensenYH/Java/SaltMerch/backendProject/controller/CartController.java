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
    public List<CartItem> selectAllIteams(CartItem item){

        return cartService.selectAllItems();
    }


    //Almost done
    @GetMapping("/carts/{id}")

    public ResponseEntity<List<CartItem>> addIteamToTheCart(@PathVariable  int id) {

        return new ResponseEntity<>(cartService.selectAllItems() , HttpStatus.OK);
    }

    @PatchMapping ("/carts/{id}{action}")
    ////PATCH /api/v1/carts/{id}?action=add
    //PATCH /api/v1/carts/{id}?action=remove
    public ResponseEntity<Object>  removeIteamFromCart(@PathVariable int id,
                                                       @RequestParam ("action") CartItem action ) {


        if (action.equals("remove")) {
            cartService.deleteOrDecrementItem(action);

        } else if (action.equals("add")) {
            cartService.insertOrIncrementItem(action);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/carts{id}")
    public ResponseEntity<Integer> deleteAllItems(@PathVariable CartItem id){

        int n = cartService.deleteOrDecrementItem(id);
        return  ResponseEntity.ok(n);
    }

    @PutMapping("/carts/{id}{buyout}")
    //DELETE /api/v1/carts/{id}?buyout=true
    public  void reStockIteam(@PathVariable int id,
                                          @RequestParam("bayout") boolean bayout){
        cartService.deleteAllItems(bayout);

    }


}
