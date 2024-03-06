package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ACCNT_PTNR_MAP")
@Data
public class AccountPartnerMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCNT_PTNR_MAP_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLNT_ACCNT_ID")
    private ClientAccount clientAccount;

    @ManyToOne
    @JoinColumn(name = "PTNR_MEMBR_ID")
    private PartnerMember partnerMember;

    // Getters and setters
}

