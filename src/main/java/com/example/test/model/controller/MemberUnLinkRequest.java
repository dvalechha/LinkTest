package com.example.test.model.controller;

import lombok.Data;

@Data
public class MemberUnLinkRequest {

    String clientCard;

    String partnerCode;

    String partnerLoyaltyId;
}
