package com.sps.springbootproductservice.service;

import com.sps.springbootproductservice.dto.GenericProductDto;
import com.sps.springbootproductservice.exceptions.NotFoundException;
import com.sps.springbootproductservice.thirdpartyclients.FakeStoreProductDto;
import com.sps.springbootproductservice.thirdpartyclients.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private FakeStoreProductServiceClient fakeStoreProductClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    @Override
    public List<GenericProductDto> getProductList() {
        List<FakeStoreProductDto> fakeStoreProductDtoList = fakeStoreProductClient.getProductList();
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            genericProductDtoList.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {
        return convertToGenericProductDto(fakeStoreProductClient.getProductById(id));
    }


    private GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(Double.parseDouble(fakeStoreProductDto.getPrice()));
        return genericProductDto;
    }
}
