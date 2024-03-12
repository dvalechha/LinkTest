package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ACCNT_PTNR_MAP")
@Data
public class AccountPartnerMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCNT_PTNR_MAP_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLNT_ACCNT_ID", nullable = false)
    private ClientAccount clientAccount;

    @ManyToOne
    @JoinColumn(name = "PTNR_MEMBR_ID", nullable = false)
    private PartnerMember partnerMember;

    // Getters and setters
}

