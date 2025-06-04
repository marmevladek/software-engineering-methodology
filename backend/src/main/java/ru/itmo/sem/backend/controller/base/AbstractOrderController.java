package ru.itmo.sem.backend.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.itmo.sem.backend.model.order.BaseOrder;
import ru.itmo.sem.backend.payload.response.base.BaseOrderResponse;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;

import java.util.List;
import java.util.UUID;

public class AbstractOrderController <T extends BaseOrder, R extends BaseOrderResponse> {
    protected final BaseOrderService<T, R> orderService;

    protected AbstractOrderController(BaseOrderService<T, R> orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<R>> findAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<R> findOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Void> completedOrder(@PathVariable UUID id) {
        orderService.completedOrder(id);
        return ResponseEntity.ok().build();
    }
}
