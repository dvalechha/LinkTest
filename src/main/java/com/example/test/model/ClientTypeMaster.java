package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CLNT_TYP_MASTR")
@Data
public class ClientTypeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLNT_TYP_MASTR_ID")
    private Long id;

    @Column(name = "CLNT_TYP_CD")
    private String clientTypeCode;
}
