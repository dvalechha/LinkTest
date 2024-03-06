package com.example.test.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "PRD_MASTR")
@Data
public class ProductMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRD_MASTR_ID")
    private Long id;

    @Column(name = "PRD_CD")
    private String productCode;

    // Getters and setters
}
