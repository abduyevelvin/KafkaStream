package com.email.kafka.service;

import com.email.kafka.dto.EmailEventDTO;
import com.email.kafka.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService {
    private static final Logger LOG = LoggerFactory.getLogger(KafKaProducerService.class);

    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafKaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void saveCreateUserLog(EmailEventDTO emailEventDTO)
    {
        LOG.info(String.format("EmailEventDTO: %s in topic: %s", emailEventDTO, AppConstants.TOPIC_NAME));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, emailEventDTO);
    }
}
