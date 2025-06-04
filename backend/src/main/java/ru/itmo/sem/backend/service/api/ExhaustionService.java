package ru.itmo.sem.backend.service.api;


import ru.itmo.sem.backend.dto.MagicDTO;
import ru.itmo.sem.backend.model.order.ExhaustionOrder;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;

public interface ExhaustionService extends BaseOrderService<ExhaustionOrder, ExhaustionOrderResponse> {
    MagicDTO addMagic(MagicDTO magicDTO, String orderId);
}
