package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "ACCNT_TKN")
@Getter
@Setter
public class AccountToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCNT_TKN_ID")
    private Long id;

    @Column(name = "TKN_MASTER_ID")
    private int tokenMasterId;

    @Column(name = "TKN_NO")
    private String tokenNo;

    @Column(name = "HASH_TKN_NO")
    private String hashTokenNo;

    @ManyToOne
    @JoinColumn(name = "CLNT_ACCNT_ID", referencedColumnName = "CLNT_ACCNT_ID")
    private ClientAccount clientAccount;

    @OneToOne(mappedBy = "accountToken")
    private PartnerTokenMap partnerTokenMap;

    // Getters and setters
}

