package com.example.test.controller;

import com.example.test.model.controller.MemberRequest;
import com.example.test.model.error.ErrorResponse;
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
public class PartnerController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/member/enroll")
    public ResponseEntity<?> enrollMember(
                                @RequestBody MemberRequest memberRequest,
                                @RequestHeader(value = "requestId", required = true) String requestId) {
        try {
            enrollmentService.enrollMember(memberRequest);
            return ResponseEntity.ok("Enrollment Complete !!");
        } catch (Exception e) {
            //In actual implementation, different types of error should map to different codes
            ErrorResponse errorResponse = new ErrorResponse("LL-SVC-100",  e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/member/unenroll")
    public ResponseEntity<?> unenrollMember(@RequestHeader(value = "requestId", required = true) String requestId,
                                                 @RequestBody MemberRequest memberRequest) {
        try {
            enrollmentService.unenrollMember(memberRequest);
            return ResponseEntity.ok("Un-enrollment Complete");
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("LL-SVC-101",  e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
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

