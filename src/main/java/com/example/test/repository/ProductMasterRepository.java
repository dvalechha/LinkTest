package com.example.test.repository;

import com.example.test.model.PartnerMember;
import com.example.test.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Long> {
}
