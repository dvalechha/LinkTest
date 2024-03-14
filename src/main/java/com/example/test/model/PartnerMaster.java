package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "PTNR_MSTR")
@Getter
@Setter
public class PartnerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PTNR_MSTR_ID")
    private Long id;

    @Column(name = "PTNR_CODE")
    private String partnerCode;

    @Column(name = "PTNR_NAME")
    private String partnerName;

    @OneToMany(mappedBy = "partnerMaster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartnerMember> partnerMembers;

    // Getters and setters
}
