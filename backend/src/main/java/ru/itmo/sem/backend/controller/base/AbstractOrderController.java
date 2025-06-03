package ru.itmo.sem.backend.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.itmo.sem.backend.model.BaseOrder;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.service.api.OrderService;

import java.util.List;
import java.util.UUID;

public class AbstractOrderController <T extends BaseOrder> {
    protected final OrderService<T> orderService;

    protected AbstractOrderController(OrderService<T> orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponse> findOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Void> processOrder(@PathVariable UUID id) {
        orderService.processOrder(id);
        return ResponseEntity.ok().build();
    }
}
