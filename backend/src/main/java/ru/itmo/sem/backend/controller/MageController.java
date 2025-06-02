package ru.itmo.sem.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.service.MageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mage")
public class MageController {

    private final MageService mageService;


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(mageService.createUser(userRequest), HttpStatus.CREATED);

    }

    @PostMapping("/order")
    public ResponseEntity<?> orderMagic(@RequestBody OrderRequest orderRequest) {
        return null;
    }
}
