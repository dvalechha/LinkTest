package com.example.test.service;

import com.example.test.model.AccountPartnerMap;
import com.example.test.model.PartnerMaster;
import com.example.test.model.PartnerMember;
import com.example.test.model.controller.MemberRequest;
import com.example.test.repository.PartnerMasterRepository;
import com.example.test.repository.PartnerMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private PartnerMasterRepository partnerMasterRepository;

    @Autowired
    private PartnerMemberRepository partnerMemberRepository;


    @Transactional
    public void enrollMember(String partnerLoyaltyId, String partnerCode, String clientCard) {
        // Task 1: Fetch ID from PTNR_MSTR table for partnerCode = 'GOOGLE'

    }

    public void enrollMember(MemberRequest memberRequest) {
        String partnerCode = memberRequest.getPartnerCode();
        String partnerLoyaltyId = memberRequest.getPartnerLoyaltyId();

        PartnerMaster partnerMaster = partnerMasterRepository.findByPartnerCode(partnerCode);

        if (partnerMaster != null) {
            PartnerMember partnerMember = new PartnerMember();
            partnerMember.setId(Double.valueOf(Math.random()).intValue());
            partnerMember.setPartnerLoyaltyId(partnerLoyaltyId);
            partnerMember.setPartnerMaster(partnerMaster);

            try {
                partnerMemberRepository.save(partnerMember);
            } catch (Exception e) {
                throw e;
            }
        } else {
            // Handle if partnerCode is not found
            throw new RuntimeException("Partner with code - " + partnerCode + " not found");
        }
    }

    private List<AccountPartnerMap> addPartnerMemberToList(AccountPartnerMap accountPartnerMap) {
        List<AccountPartnerMap> partnerMemberList = new ArrayList<>();
        partnerMemberList.add(accountPartnerMap);

        return partnerMemberList;
    }

    @Transactional
    public void unenrollMember(MemberRequest memberRequest) {
        // Retrieve PartnerMaster entity based on partnerCode
        PartnerMaster partnerMaster = partnerMasterRepository.findByPartnerCode(memberRequest.getPartnerCode());
        if (partnerMaster != null) {
            // Retrieve PartnerMember entity based on partnerLoyaltyId and PTNR_MSTR_ID
            PartnerMember partnerMember = partnerMemberRepository.findByPartnerLoyaltyIdAndPartnerMaster(memberRequest.getPartnerLoyaltyId(), partnerMaster);
            if (partnerMember != null) {
                // Remove the retrieved PartnerMember entity
                partnerMemberRepository.delete(partnerMember);
            } else {
                // Handle the case where no matching PartnerMember is found
                throw new RuntimeException("Partner member not found.");
            }
        } else {
            // Handle the case where no matching PartnerMaster is found
            throw new RuntimeException("Partner master record not found.");
        }
    }
}


