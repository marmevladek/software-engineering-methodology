package ru.itmo.sem.backend.service.api;

import ru.itmo.sem.backend.payload.response.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService<T> {
    List<OrderResponse> findAll();
    OrderResponse findById(UUID id);
    void processOrder(UUID id);
}
