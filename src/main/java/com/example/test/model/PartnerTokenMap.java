package com.example.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PTNR_TKN_MAP")
public class PartnerTokenMap {
    @Id
    @Column(name = "PTNR_TKN_MAP_ID")
    private int partnerTokenMapId;

    @OneToOne
    @JoinColumn(name = "ACCNT_TKN_ID", referencedColumnName = "ACCNT_TKN_ID")
    private AccountToken accountToken;

    @ManyToOne
    @JoinColumn(name = "PTNR_MSTR_ID", referencedColumnName = "PTNR_MSTR_ID")
    private PartnerMaster partnerMaster;

    // Getters and setters
}
