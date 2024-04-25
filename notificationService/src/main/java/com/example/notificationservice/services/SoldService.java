package com.example.notificationservice.services;

import com.example.notificationservice.entities.Bought;
import com.example.notificationservice.entities.Sold;

import java.util.List;

public interface SoldService {

    void listener(String data);

    List<Sold> userSold(String userEmail);
}
