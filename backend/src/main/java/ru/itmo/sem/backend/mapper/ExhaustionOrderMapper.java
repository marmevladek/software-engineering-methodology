package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.order.ExhaustionOrder;
import ru.itmo.sem.backend.payload.request.ExhaustionOrderRequest;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;

public class ExhaustionOrderMapper {

    public static ExhaustionOrder toEntity(ExhaustionOrderRequest request) {
        ExhaustionOrder order = GenericOrderMapper.toEntity(request, ExhaustionOrder::new);
        order.setMagicId(request.getMagicId());
        return order;
    }

    public static ExhaustionOrderResponse toResponse(ExhaustionOrder order) {
        ExhaustionOrderResponse response = new ExhaustionOrderResponse();
        GenericOrderMapper.mapBaseOrderToResponse(order, response);
        response.setMagicId(order.getMagicId());
        return response;
    }
}
