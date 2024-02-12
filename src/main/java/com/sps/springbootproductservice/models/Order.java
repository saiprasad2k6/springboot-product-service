package com.sps.springbootproductservice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order extends BaseModel {
    @ManyToMany
    @JoinTable (name = "product_orders",
            joinColumns = @JoinColumn (name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
