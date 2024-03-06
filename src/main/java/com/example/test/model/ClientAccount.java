package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "CLNT_ACCNT")
@Data
public class ClientAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLNT_ACCNT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLNT_PRFL_ID")
    private ClientProfile clientProfile;

    @OneToMany
    private List<AccountToken> accountTokenList;

    @OneToMany
    private List<AccountPartnerMap> accountPartnerMapList;

    @Column(name = "PAYMENT_CRD_NUM")
    private String paymentCardNumber;

    @Column(name = "LID_HASH")
    private String lidHash;

    @Column(name = "CLNT_ACCNT_TYPE")
    private String clientAccountType;

    @ManyToOne
    @JoinColumn(name = "PRD_MASTR_ID")
    private ProductMaster productMaster;

    // Getters and setters
}


