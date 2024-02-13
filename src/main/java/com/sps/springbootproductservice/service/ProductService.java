package com.sps.springbootproductservice.service;

import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    public List<GenericProductDto> getProductList();
    public GenericProductDto getProductById(String id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto productDto);
}
