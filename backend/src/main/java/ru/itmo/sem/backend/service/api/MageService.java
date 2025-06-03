package ru.itmo.sem.backend.service.api;

import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;

public interface MageService {

    UserResponse createUser(UserRequest userRequest);
    OrderResponse createMagicOrder(OrderRequest orderRequest);
}
