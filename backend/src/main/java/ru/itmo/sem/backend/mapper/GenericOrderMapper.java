package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.order.BaseOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.response.OrderResponse;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class GenericOrderMapper {

    public static <T extends BaseOrder> T toEntity(OrderRequest orderRequest, Supplier<T> constructor) {
        T order = constructor.get();
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setTitle(orderRequest.getTitle());
        order.setDeadline(orderRequest.getDeadline());
        order.setQuantity(orderRequest.getQuantity());
        return order;
    }

    public static <T extends BaseOrder> void mapBaseOrderToResponse(T order, OrderResponse orderResponse) {
        orderResponse.setId(order.getId());
        orderResponse.setCreatedAt(LocalDateTime.now());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setTitle(order.getTitle());
        orderResponse.setDeadline(order.getDeadline());
        orderResponse.setQuantity(order.getQuantity());
    }
}
