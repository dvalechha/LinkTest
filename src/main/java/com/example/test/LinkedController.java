package com.example.test;

import com.example.test.model.controller.MemberEnrollmentRequest;
import com.example.test.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class LinkedController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/member/enroll")
    public ResponseEntity<String> enrollMember(
                                @RequestBody MemberEnrollmentRequest memberEnrollmentRequest,
                                @RequestHeader(value = "requestId", required = true) String requestId) {
        enrollmentService.enrollMember(memberEnrollmentRequest.getPartnerCode(),
                                        memberEnrollmentRequest.getPartnerLoyaltyId());

        return new ResponseEntity<>("Enrollment successful", HttpStatus.OK);
    }
}

