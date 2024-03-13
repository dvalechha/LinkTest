package com.example.test.repository;

import com.example.test.model.AccountPartnerMap;
import com.example.test.model.PartnerMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountPartnerMapRepository extends JpaRepository<AccountPartnerMap, Long> {
    AccountPartnerMap findByPartnerMember(PartnerMember partnerMember);
}
