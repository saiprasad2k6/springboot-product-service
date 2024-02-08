package com.sps.springbootproductservice.thirdpartyclients;

import com.sps.springbootproductservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServiceClient {
    private final String fakeStoreProductServiceEndpoint;
    private RestTemplate restTemplate;
    private String fakeStoreApiEndpoint;
    private String fakeStoreProductServicePath;

    public FakeStoreProductServiceClient(RestTemplate restTemplate, @Value("${fakestore.api.endpoint}") String fakeStoreApiEndpoint, @Value("${fakestore.api.path.product}") String fakeStoreProductServicePath) {
        this.restTemplate = restTemplate;
        this.fakeStoreApiEndpoint = fakeStoreApiEndpoint;
        this.fakeStoreProductServicePath = fakeStoreProductServicePath;
        this.fakeStoreProductServiceEndpoint = fakeStoreApiEndpoint + fakeStoreProductServicePath;
    }

    public List<FakeStoreProductDto> getProductList() {
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(this.fakeStoreProductServiceEndpoint, FakeStoreProductDto[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody())).toList();

    }

    public FakeStoreProductDto getProductById(String id) throws NotFoundException {
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(this.fakeStoreProductServiceEndpoint+"/{id}", FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (null == fakeStoreProductDto) {
            throw new NotFoundException("Product with id" + id + "not found");
        }

        return fakeStoreProductDto;
    }
}
