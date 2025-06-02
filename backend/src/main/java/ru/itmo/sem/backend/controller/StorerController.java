package ru.itmo.sem.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.model.MagicOrder;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.service.StorerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storer")
public class StorerController {

    private final StorerService storerService;

    @GetMapping("/orders")
    public ResponseEntity<List<MagicOrderResponse>> findAllMagicOrders() {
        return new ResponseEntity<>(storerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<MagicOrderResponse> findMagicOrderById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(storerService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public void processMagicOrder(@PathVariable("id") UUID id) {
        storerService.processOrder(id);
    }
}
