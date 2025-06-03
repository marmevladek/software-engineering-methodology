package ru.itmo.sem.backend.controller;

import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.controller.base.AbstractOrderController;
import ru.itmo.sem.backend.model.MagicOrder;
import ru.itmo.sem.backend.service.api.OrderService;


@RestController
@RequestMapping("/api/storer")
public class StorerController extends AbstractOrderController<MagicOrder> {

    protected StorerController(OrderService<MagicOrder> orderService) {
        super(orderService);
    }
}
