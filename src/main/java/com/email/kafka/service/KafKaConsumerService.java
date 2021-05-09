package com.email.kafka.service;

import com.email.kafka.dto.EmailEventDTO;
import com.email.kafka.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafKaConsumerService {
    private static final Logger LOG = LoggerFactory.getLogger(KafKaConsumerService.class);

    private IEmailEventService emailEventService;

    @Autowired
    public KafKaConsumerService(IEmailEventService emailEventService) {
        this.emailEventService = emailEventService;
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(EmailEventDTO emailEventDTO)
    {
        LOG.info(String.format("EmailEventDTO: %s in topic: %s", emailEventDTO, AppConstants.TOPIC_NAME));
        emailEventService.addEmail(emailEventDTO);
    }
}
