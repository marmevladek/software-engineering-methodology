package ru.itmo.sem.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.service.HunterService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hunter")
public class HunterController {

    private final HunterService hunterService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> findAllCreatureOrders() {
        return new ResponseEntity<>(hunterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponse> findCreatureOrderById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(hunterService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public void processCreatureOrder(@PathVariable("id") UUID id) {
        hunterService.processOrder(id);
    }
}
