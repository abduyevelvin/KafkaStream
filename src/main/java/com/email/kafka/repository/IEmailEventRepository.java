package com.email.kafka.repository;

import com.email.kafka.model.EmailEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmailEventRepository extends JpaRepository<EmailEvent, Long> {
}
