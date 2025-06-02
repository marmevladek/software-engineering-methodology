package ru.itmo.sem.backend.service;

import ru.itmo.sem.backend.payload.response.MagicOrderResponse;

import java.util.List;
import java.util.UUID;

public interface StorerService {
    List<MagicOrderResponse> findAll();
    MagicOrderResponse findById(UUID id);
    void processOrder(UUID id);
}
