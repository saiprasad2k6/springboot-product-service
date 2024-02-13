package com.sps.springbootproductservice.service;

import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public List<GenericProductDto> getProductList() {
        return null;
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        return null;
    }
}
