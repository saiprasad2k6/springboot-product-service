package com.sps.springbootproductservice.demo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_student")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private double psp;
    private double attendance;
}
