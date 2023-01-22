package se.JensenYH.Java.SaltMerch.backendProject.controller;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se.JensenYH.Java.SaltMerch.backendProject.Model.Product;
import se.JensenYH.Java.SaltMerch.backendProject.repository.CartRepository;
import se.JensenYH.Java.SaltMerch.backendProject.repository.ProductRepository;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se.JensenYH.Java.SaltMerch.backendProject.repository.CartRepository;
import se.JensenYH.Java.SaltMerch.backendProject.repository.ProductRepository;
import se.JensenYH.Java.SaltMerch.backendProject.service.CartService;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductControllerTest extends PlaceHoldersForTest {
        final String baseUrl = "/api/v1/";
        private CartService cartService;
        private ProductService productService;

        @Autowired
        private WebApplicationContext webApplicationContext;

        private MockMvc mockMvc;

        @Mock
        @Autowired
        private CartRepository cartRepository;

        @Mock
        @Autowired
        private ProductRepository productRepository;


        private List<Product> valuess;
        @BeforeEach
        public void setup () throws Exception{
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
            cartRepository = Mockito.mock(CartRepository.class);
            productRepository = Mockito.mock(ProductRepository.class);

        }

        @Test
        void getProducts() throws Exception {


            RequestBuilder request = MockMvcRequestBuilders.get(baseUrl + "/hello");
            MvcResult result = mockMvc.perform(request).andReturn();
            assertEquals("hello", result.getResponse().getContentAsString());

        }






    @Test
    void getAllProducts() {

    }

    @Test
    void getAllProductsCategory() {
    }

    @Test
    void createNewProduct() {
    }

    @Test
    void restock() {
    }

    @Test
    void deleteProduct() {
    }
}