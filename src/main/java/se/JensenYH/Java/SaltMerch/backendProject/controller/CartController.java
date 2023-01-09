package se.JensenYH.Java.SaltMerch.backendProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.JensenYH.Java.SaltMerch.backendProject.model.CartItem;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;
    @GetMapping("/selectall")
    public List<CartItem> selectAllIteams(){
        return cartService.selectAllItems();
    }


    //Almost done
    @PostMapping("/iteam/{add}")
    public void  addIteamToTheCart(CartItem item) {

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
