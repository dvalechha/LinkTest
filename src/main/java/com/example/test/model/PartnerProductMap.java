package com.example.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PTNR_PRD_MAP",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"PRD_MASTER_ID", "PTNR_MASTER_ID"}))
@Getter
@Setter
public class PartnerProductMap {
    @Id
    @Column(name = "PTNR_PRD_MAP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int partnerProductMapId;

    @ManyToOne
    @JoinColumn(name = "PTNR_MSTR_ID", referencedColumnName = "PTNR_MSTR_ID")
    private PartnerMaster partnerMaster;

    @ManyToOne
    @JoinColumn(name = "PRD_MASTR_ID", referencedColumnName = "PRD_MASTR_ID")
    private ProductMaster productMaster;

    // Getters and setters
}
