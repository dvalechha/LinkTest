package com.example.test;

import ch.qos.logback.core.net.server.Client;
import com.example.test.model.*;
import com.example.test.model.controller.MemberLinkRequest;
import com.example.test.repository.*;
import com.example.test.service.MemberLinkService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
public class MemberLinkServiceTest {

    @Mock
    private ClientProfileRepository clientProfileRepository;

    @Mock
    private ClientAccountRepository clientAccountRepository;

    @Mock
    private AccountPartnerMapRepository accountPartnerMapRepository;

    @Mock
    private PartnerMemberRepository partnerMemberRepository;

    @Mock
    private PartnerMasterRepository partnerMasterRepository;

    @InjectMocks
    private MemberLinkService memberLinkService;

    @Test
    @Transactional
    public void testLink() throws Exception {
        assert (true);
    }
}

