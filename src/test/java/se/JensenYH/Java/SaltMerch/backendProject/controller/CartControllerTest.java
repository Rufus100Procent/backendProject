package se.JensenYH.Java.SaltMerch.backendProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import se.JensenYH.Java.SaltMerch.backendProject.Model.CartItem;

class CartControllerTest {

    @Autowired
    CartController cartController;


    //working.
    @Test
    void testRemoveOrAdd() {
        cartController = new CartController();
        ResponseEntity<Integer> actualRemoveOrAddResult = cartController.removeOrAdd(1, "Action",
                new CartItem(123, "Dr", "Color", "Size", "Preview Image"));
        assertNull(actualRemoveOrAddResult.getBody());
        assertEquals(400, actualRemoveOrAddResult.getStatusCodeValue());
        assertTrue(actualRemoveOrAddResult.getHeaders().isEmpty());
    }
    //working
    @Test
    void testRemoveOrAdd4() {
        ResponseEntity<Integer> actualRemoveOrAddResult = (new CartController()).removeOrAdd(1, "Action",
                mock(CartItem.class));
        assertNull(actualRemoveOrAddResult.getBody());
        assertEquals(400, actualRemoveOrAddResult.getStatusCodeValue());
        assertTrue(actualRemoveOrAddResult.getHeaders().isEmpty());
    }
}

