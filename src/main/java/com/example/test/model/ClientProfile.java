package com.example.test.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLNT_PRFL")
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLNT_PRFL_ID")
    private Long id;

    @OneToMany
    private List<ClientAccount> clientAccountList;

    @Column(name = "SRF")
    private String srf;

    @Column(name = "CLIENT_CARD_NO")
    private String clientCardNumber;

    @Column(name = "LID_HASH")
    private String lidHash;

    @OneToMany(mappedBy = "clientProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientAccount> clientAccounts;

    @OneToOne
    @JoinColumn(name = "CLNT_TYP_MASTR_ID", referencedColumnName = "CLNT_TYP_MASTR_ID")
    private ClientTypeMaster clientTypeMaster;

    // Getters and setters
}
