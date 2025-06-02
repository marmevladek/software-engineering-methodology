package ru.itmo.sem.backend.service;

import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.UserResponse;

public interface MageService {

    UserResponse createUser(UserRequest userRequest);
}
