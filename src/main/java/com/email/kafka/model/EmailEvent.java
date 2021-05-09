package com.email.kafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
@NoArgsConstructor
@Getter
@ToString
public class EmailEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Email cannot be empty and should be correct format")
    private String email;

    public EmailEvent(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailEvent event = (EmailEvent) o;
        return  Objects.equals(email, event.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
