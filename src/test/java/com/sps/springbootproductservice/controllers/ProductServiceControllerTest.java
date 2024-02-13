package com.sps.springbootproductservice.controllers;

import com.sps.springbootproductservice.controller.ProductServiceController;
import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import com.sps.springbootproductservice.service.ProductService;
import com.sps.springbootproductservice.thirdpartyclients.FakeStoreProductServiceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductServiceControllerTest {
    @Autowired
    private ProductServiceController productServiceController;

    @Autowired
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @MockBean
    private ProductService productService;

    @Captor
    private ArgumentCaptor<String> idCaptor;

    @Test
    void returnsNullWhenProductDoesNotExists() throws NotFoundException {
        when(productService.getProductById(any(String.class))).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> productServiceController.getProductById("121L"));
    }


    @Test
    void productControllerCallsProductServiceWithSameProductId() throws NotFoundException {
        String ID = "someId";
        when(productService.getProductById(any())).thenReturn(new GenericProductDto());
        productServiceController.getProductById(ID);

        verify(productService).getProductById(idCaptor.capture());
        Assertions.assertEquals(ID, idCaptor.getValue());
    }
}
