package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.BaseOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.response.OrderResponse;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class GenericOrderMapper {

    public static <T extends BaseOrder> T toEntity(OrderRequest orderRequest, Supplier<T> constructor) {
        T order = constructor.get();
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.NEW);
        return order;
    }

    public static <T extends BaseOrder> OrderResponse toResponse(T order) {
        return new OrderResponse(
                order.getId(),
                order.getCreatedAt(),
                order.getStatus(),
                order.getTitle()
        );
    }
}
