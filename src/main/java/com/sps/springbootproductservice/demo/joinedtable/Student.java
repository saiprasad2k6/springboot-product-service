package com.sps.springbootproductservice.demo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_student")
@Getter
@Setter
public class Student extends User {
    private double psp;
    private double attendance;
}
