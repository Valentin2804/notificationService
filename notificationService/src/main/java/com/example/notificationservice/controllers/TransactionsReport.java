package com.example.notificationservice.controllers;

import com.example.notificationservice.entities.Bought;
import com.example.notificationservice.entities.Sold;
import com.example.notificationservice.services.impl.BoughtServiceImpl;
import com.example.notificationservice.services.impl.SoldServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsReport {

    private final BoughtServiceImpl boughtService;

    private final SoldServiceImpl soldService;

    public TransactionsReport(BoughtServiceImpl boughtService, SoldServiceImpl soldService) {
        this.boughtService = boughtService;
        this.soldService = soldService;
    }

    @GetMapping("/getBought")
    public List<Bought> sendBoughtTransactions(String email){
        return boughtService.userBought(email);
    }

    @GetMapping("/getSold")
    public List<Sold> sendSoldTransactionsUser(String email){
        return soldService.userSold(email);
    }
}
