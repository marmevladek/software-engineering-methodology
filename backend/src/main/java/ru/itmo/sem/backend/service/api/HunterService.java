package ru.itmo.sem.backend.service.api;


import ru.itmo.sem.backend.dto.CreatureDTO;
import ru.itmo.sem.backend.model.order.CreatureOrder;
import ru.itmo.sem.backend.payload.request.CreatureOrderRequest;
import ru.itmo.sem.backend.payload.request.ExhaustionOrderRequest;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.response.AvailabilityResponse;
import ru.itmo.sem.backend.payload.response.CreatureOrderResponse;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;
import ru.itmo.sem.backend.payload.response.OrderResponse;

public interface HunterService extends OrderService<CreatureOrder, CreatureOrderResponse> {
    ExhaustionOrderResponse createOrder(ExhaustionOrderRequest orderRequest);
    CreatureDTO addCreature(CreatureDTO creatureDTO);
    AvailabilityResponse checkAvailability(Long id, int requestedQuantity);
}