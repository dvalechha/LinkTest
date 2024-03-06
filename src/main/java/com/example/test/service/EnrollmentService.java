package com.example.test.service;

import com.example.test.model.AccountPartnerMap;
import com.example.test.model.ClientAccount;
import com.example.test.model.PartnerMaster;
import com.example.test.model.PartnerMember;
import com.example.test.repository.PartnerMasterRepository;
import com.example.test.repository.PartnerMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private PartnerMasterRepository partnerMasterRepository;

    @Autowired
    private PartnerMemberRepository partnerMemberRepository;


    @Transactional
    public void enrollMember(String partnerLoyaltyId, String partnerCode) {
        // Task 1: Fetch ID from PTNR_MSTR table for partnerCode = 'GOOGLE'
        PartnerMaster partnerMaster = partnerMasterRepository.findByPartnerCode(partnerCode);

        if (partnerMaster != null) {
            // Task 2: Insert single record into PTNR_MEMBR and ACCNT_PTNR_MAP table
            PartnerMember partnerMember = new PartnerMember();
            partnerMember.setPartnerLoyaltyId(partnerLoyaltyId);
            partnerMember.setPartnerMaster(partnerMaster);

            // Create AccountPartnerMap with clientAccount set to null
            AccountPartnerMap accountPartnerMap = new AccountPartnerMap();
            accountPartnerMap.setPartnerMember(partnerMember);
            accountPartnerMap.setClientAccount(null);

            partnerMember.setAccountPartnerMapList(addPartnerMemberToList(accountPartnerMap));
            partnerMember = partnerMemberRepository.save(partnerMember);

        } else {
            // Handle if partnerCode 'GOOGLE' not found
            throw new RuntimeException("Partner with code - " + partnerCode + "not found");
        }
    }

    private List<AccountPartnerMap> addPartnerMemberToList(AccountPartnerMap accountPartnerMap) {
        List<AccountPartnerMap> partnerMemberList = new ArrayList<>();
        partnerMemberList.add(accountPartnerMap);

        return partnerMemberList;
    }
}


