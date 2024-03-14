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

    @Column(name = "TKN_NO")
    private String tokenNumber;

    @Column(name = "HASH_TKN_NO")
    private String hashedTokenNumber;

    @Column(name = "LAST_UPD_BY", columnDefinition = "VARCHAR(255) DEFAULT 'service'")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPD_DT", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ACCOUNT_ID", nullable = false)
    private ClientAccount clientAccount;

    @OneToOne
    @JoinColumn(name = "TKN_MASTER_ID", referencedColumnName = "TKN_MASTER_ID")
    private TokenMaster tokenMaster;

    // Getters and setters
}

