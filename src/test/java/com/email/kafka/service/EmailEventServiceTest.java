package com.email.kafka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.email.kafka.dto.ResponseDTO;
import com.email.kafka.model.EmailEvent;
import com.email.kafka.repository.IEmailEventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class EmailEventServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(EmailEventServiceTest.class);

    @Autowired
    private IEmailEventService emailEventService;

    @MockBean(name = "emailRepo")
    private IEmailEventRepository emailRepo;

    @Test
    public void getAllEmailEventsTest() {
        List<EmailEvent> emails = new ArrayList<>();
        EmailEvent event = new EmailEvent("test1@test.com");
        EmailEvent event1 = new EmailEvent("test1@google.com");
        emails.add(event);
        emails.add(event1);

        Mockito.when(emailRepo.findAll()).thenReturn(emails);
        long countOfEmails = emails.stream().distinct().count();
        long countOfDomains = emails.stream().map(e -> e.getEmail().substring(e.getEmail().indexOf("@"))).distinct().count();
        String data = String.format("There are %s emails and %s domains", countOfEmails, countOfDomains);

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(data).message("Success").status(HttpStatus.OK.value()).build();

        LOG.info("The mock response: " + response);
        LOG.info("The mocked service response: " + emailEventService.getEmails());

        Assertions.assertEquals(response, emailEventService.getEmails());
    }
}
