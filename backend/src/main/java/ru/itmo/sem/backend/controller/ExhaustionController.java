package ru.itmo.sem.backend.controller;

import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.controller.base.AbstractOrderController;
import ru.itmo.sem.backend.model.ExhaustionOrder;
import ru.itmo.sem.backend.service.api.OrderService;


@RestController
@RequestMapping("/api/exhaustion")
public class ExhaustionController extends AbstractOrderController<ExhaustionOrder> {

    protected ExhaustionController(OrderService<ExhaustionOrder> orderService) {
        super(orderService);
    }
}
