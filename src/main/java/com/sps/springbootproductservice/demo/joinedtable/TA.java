package com.sps.springbootproductservice.demo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_ta")
@Getter
@Setter
public class TA extends User {
    private double averageRating;
}
