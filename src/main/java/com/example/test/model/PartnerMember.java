package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "PTNR_MEMBR")
@Data
public class PartnerMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PTNR_MEMBR_ID")
    private Long id;

    @Column(name = "PTNR_LYLTY_ID")
    private String partnerLoyaltyId;

    @ManyToOne
    @JoinColumn(name = "PTNR_MSTR_ID")
    private PartnerMaster partnerMaster;

    @OneToMany(mappedBy="partnerMember")
    private List<AccountPartnerMap> accountPartnerMapList;

    // Getters and setters
}

