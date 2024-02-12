package com.sps.springbootproductservice.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "price")
@Getter
@Setter
public class Price extends BaseModel {
    private String currency;
    private double price;
}
