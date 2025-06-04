package ru.itmo.sem.backend.service.api.base;

import ru.itmo.sem.backend.model.order.BaseOrder;
import ru.itmo.sem.backend.payload.response.base.BaseOrderResponse;

import java.util.List;
import java.util.UUID;

public interface BaseOrderService<T extends BaseOrder, R extends BaseOrderResponse> {
    List<R> findAll();
    R findById(UUID id);
    void completedOrder(UUID id);

}
