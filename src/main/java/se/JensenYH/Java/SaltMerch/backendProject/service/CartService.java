package se.JensenYH.Java.SaltMerch.backendProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;

import se.JensenYH.Java.SaltMerch.backendProject.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository dB;

    public List<CartItem> selecttById(int id){

        if (id >= 1){

            return dB.selectAllItems();
        }
        throw new RuntimeException("product with " + id + " found");
    }

    public int addIteam(CartItem item) {
            return dB.insertOrIncrementItem(item);
    }

    public int removeIteam(CartItem item) {
            return dB.deleteOrDecrementItem(item);
    }

    public void clearCart(boolean buyout) {
        dB.deleteAllItems(false);
    }
    public void restock(int id) {
        dB.deleteAllItems(false);
    }

}
