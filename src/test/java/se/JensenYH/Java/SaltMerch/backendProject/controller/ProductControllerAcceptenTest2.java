package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerAcceptenTest2 extends ContextTest{

    @Autowired
    private MockMvc mockMvc;


    //working
    @Test
    public void createProduct() throws Exception {
        String payload = "{\n" +
                "    \"title\": \"Postman jacket\",\n" +
                "    \"description\": \"This is a jacket created from Postman\",\n" +
                "    \"previewImage\": \"images/salt-store-items/jacket/02.jpg\"\n" +
                "  \n" +
                "     \n" +
                "}";
       // RequestBuilder request = MockMvcRequestBuilders.post(getBaseUrl() + "/products/hats");
        mockMvc.perform(MockMvcRequestBuilders.post(getBaseUrl() + "/products/hats").
                        contentType(MediaType.APPLICATION_JSON_VALUE).
                        content(payload)).
                andExpect(status().isOk()).
                andReturn();

    }


    //working
    @Test
    public void createSpecificProduct() throws Exception {
        final String id = "1";
        String payload = "{\n" +
                "    \"titles\": \"jacket\",\n" +
                "    \"description\": \"This is a jacket created from \",\n" +
                "    \"previewImage\": \"images/salt-store-items/jacket/02.jpg\"\n" +
                "  \n" +
                "     \n" +
                "}";
       // RequestBuilder request = MockMvcRequestBuilders.post(getBaseUrl() + "/products/hats");
        mockMvc.perform(MockMvcRequestBuilders.post(getBaseUrl() + "/products/" + id + "/variants" ).
                        contentType(MediaType.APPLICATION_JSON_VALUE).
                        content(payload)).
                andExpect(status().isOk()).
                andReturn();

    }

    //?????
    @Test
    public void updateProduct() throws Exception{
        final String id = "7";
        String payload = "{\n" +
                "    \"title\": \"Postman jacket\",\n" +
                "    \"description\": \"This is a jacket created from Postman\",\n" +
                "    \"previewImage\": \"images/salt-store-items/jacket/02.jpg\"\n" +
                "  \n" +
                "     \n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.put(getBaseUrl() + "/produtcs/" + id).contentType(MediaType.
                APPLICATION_JSON_VALUE).content(payload)).andExpect(status().isCreated()).andReturn();
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