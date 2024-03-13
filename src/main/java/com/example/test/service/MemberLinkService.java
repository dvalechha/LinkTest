package com.example.test.service;

import com.example.test.model.*;
import com.example.test.model.controller.MemberLinkRequest;
import com.example.test.model.controller.MemberUnLinkRequest;
import com.example.test.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MemberLinkService {

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    @Autowired
    private ClientAccountRepository clientAccountRepository;

    @Autowired
    private AccountPartnerMapRepository accountPartnerMapRepository;

    @Autowired
    private PartnerMemberRepository partnerMemberRepository;

    @Autowired
    private PartnerMasterRepository partnerMasterRepository;

    @Transactional
    public void link(MemberLinkRequest linkRequest) {

        PartnerMember partnerMember = null;

        // Retrieve or create ClientProfile entity
        ClientProfile clientProfile = clientProfileRepository.findByClientCardNumber(linkRequest.getClientCard());

        if (clientProfile == null) {
            // Create new ClientProfile if not found
            clientProfile = new ClientProfile();
            clientProfile.setClientCardNumber(linkRequest.getClientCard());
            clientProfileRepository.save(clientProfile);
        }

        // Create ClientAccount entities
        List<ClientAccount> clientAccountList = linkRequest.getClientAccountList();
        for (ClientAccount clientAccount : clientAccountList) {

            try{
                AccountPartnerMap accountPartnerMap = new AccountPartnerMap();
                accountPartnerMap.setClientAccount(clientAccount);
                accountPartnerMap.setPartnerMember(
                        getPartnerMember(linkRequest.getPartnerCode(), linkRequest.getPartnerLoyaltyId()));
                accountPartnerMapRepository.save(accountPartnerMap);

                clientAccount.setClientProfile(clientProfile);
                clientAccountRepository.save(clientAccount);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void unlink(MemberUnLinkRequest unlinkRequest) {
        // Find the ClientAccount based on client card number
        /*ClientAccount clientAccount = clientAccountRepository.findByPaymentCardNumber(unlinkRequest.getClientCard());

        if (clientAccount != null) {
            // Delete the AccountPartnerMap associated with the ClientAccount
            if (clientAccount.getAccountPartnerMaps() != null) {
                accountPartnerMapRepository.delete(clientAccount.getAccountPartnerMaps());
            }

            // Delete the ClientAccount
            clientAccountRepository.delete(clientAccount);

            // Find the ClientProfile associated with the ClientAccount
            ClientProfile clientProfile = clientProfileRepository.findByClientCardNumber(unlinkRequest.getClientCard());
            if (clientProfile != null) {
                // Delete the ClientProfile
                clientProfileRepository.delete(clientProfile);
            }
        }*/
    }

    // Method to retrieve PartnerMember (Replace with your implementation)
    private PartnerMember getPartnerMember(String partnerCode, String partnerLoyaltyId) {
        PartnerMember partnerMember = null;
        PartnerMaster partnerMaster = partnerMasterRepository.findByPartnerCode(partnerCode);
        if (partnerMaster != null) {
            partnerMember = partnerMemberRepository.findByPartnerLoyaltyIdAndPartnerMaster(partnerLoyaltyId, partnerMaster);
            if (partnerMember == null) {
                throw new RuntimeException("Partner member not found.");
            }
        } else {
            throw new RuntimeException("Partner code not found.");
        }

        return partnerMember;
    }
}

