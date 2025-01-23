package com.sps.springbootproductservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity(name = "product")
@Table(schema = "product_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    @OneToOne(cascade =  {CascadeType.PERSIST}) // Save pric before saving product
    @JoinColumn(name = "price_id")
    private Price price;
    @ManyToOne(cascade =  {CascadeType.PERSIST})
    @JoinColumn(name = "category_id")
    private Category category; // product -> category 1:1 M:1 ==> M:1

}
