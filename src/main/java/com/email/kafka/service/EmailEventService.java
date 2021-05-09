package com.email.kafka.service;

import com.email.kafka.dto.EmailEventDTO;
import com.email.kafka.dto.ResponseDTO;
import com.email.kafka.enums.NotFoundErrorEnum;
import com.email.kafka.exception.EmailsNotFoundException;
import com.email.kafka.model.EmailEvent;
import com.email.kafka.repository.IEmailEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailEventService implements IEmailEventService {
    private static final Logger LOG = LoggerFactory.getLogger(EmailEventService.class);

    private IEmailEventRepository emailEventRepository;

    @Autowired
    public EmailEventService(IEmailEventRepository emailEventRepository) {
        this.emailEventRepository = emailEventRepository;
    }

    @Override
    public void addEmail(EmailEventDTO emailEventDTO) {
        EmailEvent emailEvent = new EmailEvent(emailEventDTO.getEmail());

        LOG.info(String.format("EmailEventDTO: %s is converted to EmailEvent: %s", emailEventDTO, emailEvent));

        emailEventRepository.save(emailEvent);
    }

    @Override
    public ResponseDTO<String> getEmails() {
        List<EmailEvent> emails = emailEventRepository.findAll();

        if (emails.isEmpty()) {
            throw new EmailsNotFoundException(NotFoundErrorEnum.EMAILS_NOT_FOUND);
        }

        long countOfEmails = emails.stream().distinct().count();
        long countOfDomains = emails.stream().map(e -> e.getEmail().substring(e.getEmail().indexOf("@"))).distinct().count();

        String data = String.format("There are %s emails and %s domains", countOfEmails, countOfDomains);

        LOG.info(data);

        return ResponseDTO.<String>builder().data(data).message("Success").status(HttpStatus.OK.value()).build();
    }
}
