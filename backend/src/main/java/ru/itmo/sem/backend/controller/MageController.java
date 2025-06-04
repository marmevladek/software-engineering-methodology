package ru.itmo.sem.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;
import ru.itmo.sem.backend.service.api.MageService;

import java.util.List;

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
    public ResponseEntity<MagicOrderResponse> createMagicOrder(@Valid @RequestBody MagicOrderRequest orderRequest) {
        return new ResponseEntity<>(mageService.createMagicOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<MagicOrderResponse>> findAllOrders() {
        return new ResponseEntity<>(mageService.findAllOrders(), HttpStatus.OK);
    }


}
