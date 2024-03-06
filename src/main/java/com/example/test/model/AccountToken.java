package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCNT_TKN")
@Data
public class AccountToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCNT_TKN_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TKN_MASTER_ID")
    private TokenMaster tokenMaster;

    @Column(name = "TKN_NO")
    private String tokenNumber;

    @Column(name = "HASH_TKN_NO")
    private String hashedTokenNumber;

    @Column(name = "LAST_UPD_BY", columnDefinition = "VARCHAR(255) DEFAULT 'service'")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPD_DT", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "CLNT_ACCNT_ID")
    private ClientAccount clientAccount;

    // Getters and setters
}

