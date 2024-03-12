package com.example.test.model;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRD_MASTR")
@Data
public class ProductMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRD_MASTR_ID")
    private Long id;

    @Column(name = "PRD_CD")
    private String productCode;

    @OneToOne(mappedBy = "productMaster")
    private ClientAccount clientAccount;

    // Getters and setters
}
