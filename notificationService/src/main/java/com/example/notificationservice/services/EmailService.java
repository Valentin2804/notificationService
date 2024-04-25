package com.example.notificationservice.services;

public interface EmailService {

    void send(String to, String currency, Double amount, String action);
}
