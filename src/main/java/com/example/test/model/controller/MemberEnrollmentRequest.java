package com.example.test.model.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MemberEnrollmentRequest {

    String partnerLoyaltyId;

    String clientCard;

    String partnerCode;
}
