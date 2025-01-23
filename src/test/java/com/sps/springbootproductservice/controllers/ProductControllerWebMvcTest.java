//package com.sps.springbootproductservice.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sps.springbootproductservice.controller.ProductServiceController;
//import com.sps.springbootproductservice.dto.GenericProductDto;
//import com.sps.springbootproductservice.exceptions.NotFoundException;
//import com.sps.springbootproductservice.service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
////@WebMvcTest(ProductServiceController.class)
//public class ProductControllerWebMvcTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {
//        when(productService.getProductList()).thenReturn(new ArrayList<>());
//        mockMvc.perform(get("/products"))
//                .andExpect(status().is(404))
//                .andExpect(content().string("[]"));
//    }
//
//    @Test
//    void returnListOfProductsWhenProductExists() throws Exception {
//        List<GenericProductDto> mockProductDtoList = new ArrayList<>();
//        mockProductDtoList.add(new GenericProductDto());
//        mockProductDtoList.add(new GenericProductDto());
//        mockProductDtoList.add(new GenericProductDto());
//
//        when(productService.getProductList()).thenReturn(mockProductDtoList);
//
//        mockMvc.perform(get("/products"))
//                .andExpect(content().string(objectMapper.writeValueAsString(mockProductDtoList)));
//    }
//
//    @Test
//    void createProductShouldCreateANewProduct() throws Exception {
//        GenericProductDto productToCreate = new GenericProductDto();
//        productToCreate.setTitle("Product 1");
//        productToCreate.setImage("some url");
//        productToCreate.setDescription("some description");
//        productToCreate.setPrice(1.00);
//
//        GenericProductDto expectedProductToCreate = new GenericProductDto();
//        expectedProductToCreate.setTitle("Product 1");
//        expectedProductToCreate.setImage("some url");
//        expectedProductToCreate.setDescription("some description");
//        expectedProductToCreate.setPrice(1.00);
//
//        when(productService.createProduct(any())).thenReturn(expectedProductToCreate);
//
//        mockMvc.perform(
//                        post("/products")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(productToCreate))
//                ).andExpect(
//                        content().string(objectMapper.writeValueAsString(expectedProductToCreate))
//                ).andExpect(status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", is("Product 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", is(4)));
//    }
//}
