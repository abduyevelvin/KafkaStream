package com.email.kafka.service;

import com.email.kafka.dto.EmailEventDTO;
import com.email.kafka.dto.ResponseDTO;

public interface IEmailEventService {
    void addEmail(EmailEventDTO emailEventDTO);
    ResponseDTO<String> getEmails();
}
