package com.example.notificationservice.services;

import com.example.notificationservice.entities.Bought;

import java.util.List;

public interface BoughtService {

    void listener(String data);

    List<Bought> userBought(String userEmail);
}
