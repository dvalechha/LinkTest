package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TKN_MASTER")
public class TokenMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TKN_MASTER_ID")
    private Long id;

    @Column(name = "TKN_NAME")
    private String tokenName;

    @Column(name = "TKN_TYP")
    private String tokenType;

    @Column(name = "TKN_REQUESTOR_NUM")
    private Integer requestorNumber;

    // Getters and setters
}
