package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.MagicOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;

import java.time.LocalDateTime;

public class MagicOrderMapper {

    public static MagicOrder toEntity(MagicOrderRequest magicOrderRequest) {
        return new MagicOrder(
                LocalDateTime.now(),
                OrderStatus.NEW,
                magicOrderRequest.getTitle()
        );
    }

    public static MagicOrderResponse toResponse(MagicOrder magicOrder) {
        return new MagicOrderResponse(
                magicOrder.getId(),
                magicOrder.getCreatedAt(),
                magicOrder.getStatus(),
                magicOrder.getTitle()
        );
    }
}
