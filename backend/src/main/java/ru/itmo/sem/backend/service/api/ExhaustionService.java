package ru.itmo.sem.backend.service.api;


import ru.itmo.sem.backend.dto.MagicDTO;
import ru.itmo.sem.backend.model.order.ExhaustionOrder;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;

public interface ExhaustionService extends OrderService<ExhaustionOrder, ExhaustionOrderResponse> {
    MagicDTO addMagic(MagicDTO magicDTO);
}
