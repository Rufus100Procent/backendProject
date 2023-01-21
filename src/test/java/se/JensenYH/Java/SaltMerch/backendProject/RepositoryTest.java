package se.JensenYH.Java.SaltMerch.backendProject;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
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

import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@WebAppConfiguration
public class RepositoryTest {

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


    @BeforeEach
    public void setup () throws Exception{
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        cartRepository = Mockito.mock(CartRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
    }

    @Test
    public void createProduct() throws Exception {
        String payload = "{\n" +
                "    \"title\": \"Postman jacket\",\n" +
                "    \"description\": \"This is a jacket created from Postman\",\n" +
                "    \"previewImage\": \"images/salt-store-items/jacket/02.jpg\"\n" +
                "  \n" +
                "     \n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(baseUrl + "/products/hats").
                        contentType(MediaType.APPLICATION_JSON_VALUE).
                        content(payload)).
                        andExpect(status().
                        isCreated()).
                        andReturn();
    }

    @Test
    public void fetchTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get( baseUrl + ("/api/v1/products"))).andExpect(status().isOk()).andReturn();
        System.out.println("work");
    }

}
