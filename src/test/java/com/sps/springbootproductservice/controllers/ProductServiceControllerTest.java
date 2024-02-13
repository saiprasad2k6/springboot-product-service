package com.sps.springbootproductservice.controllers;

import com.sps.springbootproductservice.controller.ProductServiceController;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import com.sps.springbootproductservice.service.ProductService;
import com.sps.springbootproductservice.thirdpartyclients.FakeStoreProductServiceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductServiceControllerTest {
    @Autowired
    private ProductServiceController productServiceController;

    @Autowired
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @MockBean
    private ProductService productService;

    @Test
    void returnsNullWhenProductDoesNotExists() throws NotFoundException {
        when(productService.getProductById(any(String.class))).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> productServiceController.getProductById("121L"));
    }
}
