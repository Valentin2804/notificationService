package com.example.notificationservice.entities;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
public class Sold {

    @PrimaryKey
    private UUID id;

    private String userEmail;

    private Long currency;

    private Double amount;

    private LocalDateTime moment;

    public Sold(String userEmail, Long currency, Double amount, LocalDateTime moment) {
        this.id = UUID.randomUUID();
        this.userEmail = userEmail;
        this.currency = currency;
        this.amount = amount;
        this.moment = moment;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }
}
