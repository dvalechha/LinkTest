package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PTNR_MSTR")
@Data
public class PartnerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PTNR_MSTR_ID")
    private Long id;

    @Column(name = "PTNR_CODE")
    private String partnerCode;

    @Column(name = "PTNR_NAME")
    private String partnerName;

    // Getters and setters
}
