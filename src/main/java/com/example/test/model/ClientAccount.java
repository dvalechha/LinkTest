package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "CLNT_ACCNT")
@Data
public class ClientAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLNT_ACCNT_ID")
    private Long id;

    @Column(name = "PAYMENT_CRD_NUM")
    private String paymentCardNumber;

    @Column(name = "LID_HASH")
    private String lidHash;

    @Column(name = "CLNT_ACCNT_TYPE")
    private String clientAccountType;

    @ManyToOne
    @JoinColumn(name = "CLNT_PRFL_ID", nullable = false)
    private ClientProfile clientProfile;

    @OneToOne
    @JoinColumn(name = "PRD_MASTR_ID", referencedColumnName = "PRD_MASTR_ID")
    private ProductMaster productMaster;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountPartnerMap> accountPartnerMaps;

    @OneToMany(mappedBy = "clientAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountToken> accountTokens;

    // Getters and setters
}


