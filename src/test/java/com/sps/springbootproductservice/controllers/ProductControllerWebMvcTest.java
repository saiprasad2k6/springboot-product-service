package com.sps.springbootproductservice.controllers;

import com.sps.springbootproductservice.controller.ProductServiceController;
import com.sps.springbootproductservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductServiceController.class)
public class ProductControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {
        when(productService.getProductList()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/"))
                .andExpect(status().is(404))
                .andExpect(content().string(""));
    }
}
