package ru.itmo.sem.backend.service.api;

import ru.itmo.sem.backend.model.order.BaseOrder;
import ru.itmo.sem.backend.payload.response.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService<T extends BaseOrder, R extends OrderResponse> {
    List<R> findAll();
    R findById(UUID id);
    void completedOrder(UUID id);

}
