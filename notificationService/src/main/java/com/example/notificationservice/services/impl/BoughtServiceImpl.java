package com.example.notificationservice.services.impl;

import com.example.notificationservice.entities.Bought;
import com.example.notificationservice.repositories.BoughtRepository;
import com.example.notificationservice.services.BoughtService;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoughtServiceImpl implements BoughtService {

    private final BoughtRepository repository;

    private final EmailServiceImpl service;

    public BoughtServiceImpl(BoughtRepository repository, EmailServiceImpl service) {
        this.repository = repository;
        this.service = service;
    }

    @KafkaListener(topics = "bought", groupId = "transactions")
    public void listener(String data) {

        Gson g = new Gson();
        ReceivedJson json = g.fromJson(data, ReceivedJson.class);

        Bought bought = new Bought(json.getUserEmailAddress(), json.getCoinId(), json.getAmount(), LocalDateTime.now());

        service.send(json.getUserEmailAddress(), json.getCoinId().toString(), json.getAmount(), "bought");

        repository.save(bought);
    }

    public List<Bought> userBought(String userEmail){
        return repository.findAllByUserEmail(userEmail);
    }
}
