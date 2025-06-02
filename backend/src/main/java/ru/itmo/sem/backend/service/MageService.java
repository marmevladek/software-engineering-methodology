package ru.itmo.sem.backend.service;

import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;

public interface MageService {

    UserResponse createUser(UserRequest userRequest);
    MagicOrderResponse createMagicOrder(MagicOrderRequest magicOrderRequest);
}
