package ru.itmo.sem.backend.service.api;

import ru.itmo.sem.backend.model.order.MagicOrder;
import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;

import java.util.List;

public interface MageService {

    UserResponse createUser(UserRequest userRequest);
    MagicOrderResponse createMagicOrder(MagicOrderRequest orderRequest);

    List<MagicOrderResponse> findAllOrders();
}
