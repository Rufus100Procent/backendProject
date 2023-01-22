package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductControllerUniteTest {


    @Test
    void getAllProductsCategory() {
        ProductService productService = Mockito.mock(ProductService.class);
        when(productService.hello("s")).thenReturn("hello");
        ProductController productController = new ProductController(productService);
        assertEquals("hello ",productController.hello("s"));
    }


}