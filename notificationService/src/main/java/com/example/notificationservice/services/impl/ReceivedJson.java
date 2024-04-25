package com.example.notificationservice.services.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReceivedJson {
    private Long userId;
    private Long coinId;
    private String userEmailAddress;
    private Double amount;
}
