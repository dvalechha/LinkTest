package com.example.test.model.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEnrollRequest {

    String partnerLoyaltyId;

    String partnerCode;
}
