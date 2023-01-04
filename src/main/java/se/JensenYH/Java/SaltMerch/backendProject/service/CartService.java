package se.JensenYH.Java.SaltMerch.backendProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.JensenYH.Java.SaltMerch.backendProject.model.CartItem;

import se.JensenYH.Java.SaltMerch.backendProject.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository dB;



    //Done 1
    public List<CartItem> selectAllItems(){
        return dB.selectAllItems();
    }


}
