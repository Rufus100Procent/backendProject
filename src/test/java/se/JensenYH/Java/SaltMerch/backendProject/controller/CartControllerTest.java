package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CartControllerTest extends ContextTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCartContents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(getBaseUrl() + "/selectall")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()) .andDo(print())
                .andExpect(status().isOk());
    }
}