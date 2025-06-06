package ru.itmo.sem.backend.service.api;


import ru.itmo.sem.backend.model.order.MagicOrder;
import ru.itmo.sem.backend.payload.request.CreatureOrderRequest;
import ru.itmo.sem.backend.payload.response.AvailabilityResponse;
import ru.itmo.sem.backend.payload.response.CreatureOrderResponse;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;

import java.util.List;

public interface StorerService extends BaseOrderService<MagicOrder, MagicOrderResponse> {
    CreatureOrderResponse createOrder(CreatureOrderRequest orderRequest);
    AvailabilityResponse checkAvailability(Long id, int requestedVolume);
    List<CreatureOrderResponse> getMyOrders();

}
