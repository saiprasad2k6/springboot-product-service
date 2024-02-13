package com.sps.springbootproductservice.controllers;

import com.sps.springbootproductservice.controller.ProductServiceController;
import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import com.sps.springbootproductservice.thirdpartyclients.FakeStoreProductServiceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductServiceControllerTest {
    @Autowired
    private ProductServiceController productServiceController;

    @Autowired
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @Test
    void returnsNullWhenProductDoesNotExists() throws NotFoundException {
        Assertions.assertThrows(NotFoundException.class, () -> productServiceController.getProductById("121L"));
    }
}
