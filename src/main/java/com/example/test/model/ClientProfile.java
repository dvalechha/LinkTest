package com.example.test.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLNT_PRFL")
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLNT_PRFL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLNT_TYP_MASTR_ID")
    private ClientTypeMaster clientTypeMaster;

    @OneToMany
    private List<ClientAccount> clientAccountList;

    @Column(name = "SRF")
    private String srf;

    @Column(name = "CLIENT_CARD_NO")
    private String clientCardNumber;

    @Column(name = "LID_HASH")
    private String lidHash;

    // Getters and setters
}
