package com.example.notificationservice.repositories;

import com.example.notificationservice.entities.Bought;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BoughtRepository extends CrudRepository<Bought, UUID> {
    List<Bought> findAllByUserEmail(String email);
}
