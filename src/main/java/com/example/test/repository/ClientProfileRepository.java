package com.example.test.repository;

import com.example.test.model.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {
    ClientProfile findByClientCardNumber(String clientCard);
}
