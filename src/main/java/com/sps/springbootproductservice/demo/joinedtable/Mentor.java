package com.sps.springbootproductservice.demo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_mentor")
@Getter
@Setter
public class Mentor extends User {
    private double averageRating;
}
