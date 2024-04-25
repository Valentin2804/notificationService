package com.example.notificationservice.services.impl;

import com.example.notificationservice.entities.Bought;
import com.example.notificationservice.entities.Sold;
import com.example.notificationservice.repositories.SoldRepository;
import com.example.notificationservice.services.SoldService;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SoldServiceImpl implements SoldService {

    private final SoldRepository repository;

    private final EmailServiceImpl service;

    public SoldServiceImpl(SoldRepository repository, EmailServiceImpl service) {
        this.repository = repository;
        this.service = service;
    }

    @KafkaListener(topics = "sold", groupId = "transactions")
    public void listener(String data) {
        System.out.println(data);

        Gson g = new Gson();
        ReceivedJson json = g.fromJson(data, ReceivedJson.class);

        Sold sold = new Sold(json.getUserEmailAddress(), json.getCoinId(), json.getAmount(), LocalDateTime.now());

        service.send(json.getUserEmailAddress(), json.getCoinId().toString(), json.getAmount(), "sold");

        repository.save(sold);
    }

    public List<Sold> userSold(String userEmail){
        return repository.findAllByUserEmail(userEmail);
    }
}
