package com.sps.springbootproductservice.controllers;

import com.sps.springbootproductservice.controller.ProductServiceController;
import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import com.sps.springbootproductservice.thirdpartyclients.FakeStoreProductServiceClient;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ProductServiceControllerTest {
    @Autowired
    private ProductServiceController productServiceController;

    @Autowired
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    void returnsNullWhenProductDoesNotExists() throws NotFoundException {
        GenericProductDto genericProductDto = productServiceController.getProductById("121L").getBody();
        Assertions.assertNull(genericProductDto);

    }
}
