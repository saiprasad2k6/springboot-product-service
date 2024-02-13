package com.sps.springbootproductservice.controller;

import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import com.sps.springbootproductservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductServiceController {
    ProductService productService = null;

    public ProductServiceController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<GenericProductDto>> getProductList() {
        List<GenericProductDto> productDtoList = productService.getProductList();
        if (productDtoList.isEmpty())
            return new ResponseEntity<>(productDtoList, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") String id) throws NotFoundException {
        GenericProductDto genericProductDto = productService.getProductById(id);
        if (genericProductDto == null)
            throw new NotFoundException("Product Not Found");

        return new ResponseEntity<>(genericProductDto, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto product) throws Exception {
        GenericProductDto genericProductDto = productService.createProduct(product);
        if (genericProductDto == null) {
            throw new Exception("Product not saved");
        }
        return new ResponseEntity<>(genericProductDto, HttpStatus.OK);


    }
}
