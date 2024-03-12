package com.example.test.repository;

import com.example.test.model.PartnerMaster;
import com.example.test.model.PartnerMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerMemberRepository extends JpaRepository<PartnerMember, Long> {
    PartnerMember findByPartnerLoyaltyIdAndPartnerMaster(String partnerLoyaltyId, PartnerMaster partnerMaster);
    // You can add custom query methods here if needed
}
