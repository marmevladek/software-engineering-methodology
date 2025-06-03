package ru.itmo.sem.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;
import ru.itmo.sem.backend.service.MageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mage")
public class MageController {

    private final MageService mageService;

    @PostMapping("/user/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(mageService.createUser(userRequest), HttpStatus.CREATED);

    }

    @PostMapping("/order/create")
    public ResponseEntity<OrderResponse> createMagicOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(mageService.createMagicOrder(orderRequest), HttpStatus.CREATED);
    }
}
