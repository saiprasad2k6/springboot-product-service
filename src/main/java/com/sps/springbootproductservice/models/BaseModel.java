package com.sps.springbootproductservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "sai")
    @GenericGenerator(name = "sai", strategy = "uuid2")
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "binary(16)")
    private UUID uuid;
}
