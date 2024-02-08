package com.sps.springbootproductservice.thirdpartyclients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private String id;
    private String title;
    private String price;
    private String category;
    private String image;
    private String description;
}
