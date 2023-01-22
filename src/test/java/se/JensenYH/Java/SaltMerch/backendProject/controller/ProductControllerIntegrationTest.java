package se.JensenYH.Java.SaltMerch.backendProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.JensenYH.Java.SaltMerch.backendProject.service.ProductService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class ProductControllerIntegrationTest {

    final String baseUrl = "/api/v1/";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService  productService;


    @Test
    void shouldGetDefualtMassage() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get(baseUrl + "/products");

        when(productService.hello("stringer")).thenReturn("wlecame stringer");
        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());

        verify(productService.hello("stringer"));
    }




}
