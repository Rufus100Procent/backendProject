package se.JensenYH.Java.SaltMerch.backendProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;

import se.JensenYH.Java.SaltMerch.backendProject.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
    public class CartService {

    @Autowired
    CartRepository dB;



    //Done 1
    public List<CartItem> selectAllItems(){
        return dB.selectAllItems();
    }

    //done 2
    public List<CartItem> insertOrIncrementItem(CartItem item) {

     return null;
    }

    //done 3
    public int deleteOrDecrementItem(CartItem item) {

     return dB.deleteOrDecrementItem(item);


    }

    public void deleteAllItems(boolean restock){
        dB.deleteAllItems(restock);
    }


    }
