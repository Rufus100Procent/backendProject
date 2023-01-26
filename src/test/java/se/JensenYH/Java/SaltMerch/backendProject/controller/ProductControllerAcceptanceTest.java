package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerAcceptanceTest extends ContextTest{

    @Autowired
    private MockMvc mockMvc;

    //working
    @Test
    public void createProduct() throws Exception {
        String payload = """
                {
                    "title": "Postman jacket",
                    "description": "This is a jacket created from Postman",
                    "previewImage": "images/salt-store-items/jacket/02.jpg"
                 \s
                    \s
                }""";
        mockMvc.perform(MockMvcRequestBuilders.post(getBaseUrl() + "/products/hats").
                        contentType(MediaType.APPLICATION_JSON_VALUE).
                        content(payload)).
                andExpect(status().isOk()).
                andReturn();

    }

    //working
    @Test
    public void getProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(getBaseUrl() + "/products")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()) .andDo(print())
                .andExpect(status().isOk());
    }
    //working
    @Test
    public void deleteProduct()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete(getBaseUrl() + "/products/1"))
                .andExpect(status().isOk());
    }
}