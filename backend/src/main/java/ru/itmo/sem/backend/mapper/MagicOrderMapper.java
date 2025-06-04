package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.order.MagicOrder;
import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;

public class MagicOrderMapper {

    public static MagicOrder toEntity(MagicOrderRequest request) {
        MagicOrder order = GenericOrderMapper.toEntity(request, MagicOrder::new);
        order.setMagicId(request.getMagicId());
        return order;
    }

    public static MagicOrderResponse toResponse(MagicOrder order) {
        MagicOrderResponse response = new MagicOrderResponse();
        GenericOrderMapper.mapBaseOrderToResponse(order, response);
        response.setMagicId(order.getMagicId());
        return response;
    }
}
