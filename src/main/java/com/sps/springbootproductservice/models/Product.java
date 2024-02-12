package com.sps.springbootproductservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@Table(schema = "product_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    private double price;
    @ManyToOne()
    @JoinColumn(name = "category")
    private Category category; // product -> category 1:1 M:1 ==> M:1

}
