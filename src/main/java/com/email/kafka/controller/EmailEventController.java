package com.email.kafka.controller;

import com.email.kafka.dto.EmailEventDTO;
import com.email.kafka.dto.ResponseDTO;
import com.email.kafka.service.IEmailEventService;
import com.email.kafka.service.KafKaProducerService;
import com.email.kafka.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Api("Email Event Controller")
public class EmailEventController {
    private KafKaProducerService kafKaProducerService;
    private IEmailEventService emailEventService;

    @Autowired
    public EmailEventController(KafKaProducerService kafKaProducerService, IEmailEventService emailEventService) {
        this.kafKaProducerService = kafKaProducerService;
        this.emailEventService = emailEventService;
    }

    @PostMapping("/")
    @ApiOperation(value = "return the count of unique email address and domains",
            notes = "need to provide the email event object")
    public ResponseDTO<String> getEmailCounts(@Valid @RequestBody EmailEventDTO emailEventDTO) throws InterruptedException {
        ResponseDTO<String> response = null;
        if (Util.checkEmail(emailEventDTO.getEmail())) {
            kafKaProducerService.saveCreateUserLog(emailEventDTO);
            Thread.sleep(10);
            response = emailEventService.getEmails();

            return response;
        }

        return response;
    }
}
