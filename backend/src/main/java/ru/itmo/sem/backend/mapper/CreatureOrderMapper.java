package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.order.CreatureOrder;
import ru.itmo.sem.backend.payload.request.CreatureOrderRequest;
import ru.itmo.sem.backend.payload.response.CreatureOrderResponse;

public class CreatureOrderMapper {
    public static CreatureOrder toEntity(CreatureOrderRequest request) {
        CreatureOrder order = GenericOrderMapper.toEntity(request, CreatureOrder::new);
        order.setName(request.getName());
        return order;
    }

    public static CreatureOrderResponse toResponse(CreatureOrder order) {
        CreatureOrderResponse response = new CreatureOrderResponse();
        GenericOrderMapper.mapBaseOrderToResponse(order, response);
        response.setName(order.getName());
        return response;
    }
}
