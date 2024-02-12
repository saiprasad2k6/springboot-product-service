package com.sps.springbootproductservice.models;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "sai")
    @GenericGenerator(name = "sai", strategy = "uuid2")
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "binary(16)")
    private UUID uuid;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, updatable = false)
//    private Long id;


}
