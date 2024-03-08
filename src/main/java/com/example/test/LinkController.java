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
public class LinkController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/member/enroll")
    public ResponseEntity<String> enrollMember(
                                @RequestBody MemberEnrollmentRequest memberEnrollmentRequest,
                                @RequestHeader(value = "requestId", required = true) String requestId) {
        enrollmentService.enrollMember(memberEnrollmentRequest);

        return new ResponseEntity<>("Enrollment successful", HttpStatus.OK);
    }

    @PostMapping("/member/unenroll")
    public ResponseEntity<String> unenrollMember() {
        return new ResponseEntity<>("Un-enroll member successful", HttpStatus.OK);
    }

    @PostMapping("/member/link")
    public ResponseEntity<String> link() {
        //TBD: POST body should accept, List of payment cards and partnerLoyaltyId.
        //Based on that, make INSERTs into CNT_PRFL, CLIENT_ACCNT and ACCNT_PART_MAP
        return new ResponseEntity<>("Link successful", HttpStatus.OK);
    }

    @PostMapping("/member/unlink")
    public ResponseEntity<String> unlink() {
        //TBD: Undo steps from link
        return new ResponseEntity<>("Unlink successful", HttpStatus.OK);
    }

    @PostMapping("/member/validate")
    public ResponseEntity<String> validate() {
        //TBD: Assess all checkpoints from where validate may get invoked, based on that
        //we can try to generalize the flow
        return new ResponseEntity<>("Validate successful", HttpStatus.OK);
    }
}

