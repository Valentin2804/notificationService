package com.example.notificationservice.repositories;

import com.example.notificationservice.entities.Bought;
import com.example.notificationservice.entities.Sold;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SoldRepository extends CrudRepository<Sold, UUID> {
    List<Sold> findAllByUserEmail(String email);
}
