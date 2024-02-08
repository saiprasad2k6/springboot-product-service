package com.sps.springbootproductservice.service;

import com.sps.springbootproductservice.dto.GenericProductDto;

import java.util.List;

public interface ProductService {
    public List<GenericProductDto> getProductList();
    public GenericProductDto getProductById(String id) throws Exception;
}
