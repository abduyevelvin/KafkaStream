package com.email.kafka.config;

import com.email.kafka.repository.IEmailEventRepository;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ConfigTest {

    @Bean
    @Qualifier("emailRepo")
    @Primary
    public IEmailEventRepository emailRepo() {
        return Mockito.mock(IEmailEventRepository.class);
    }
}
