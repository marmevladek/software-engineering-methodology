package ru.itmo.sem.backend.controller;

import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.controller.base.AbstractOrderController;
import ru.itmo.sem.backend.model.CreatureOrder;
import ru.itmo.sem.backend.service.api.OrderService;


@RestController
@RequestMapping("/api/hunter")
public class HunterController extends AbstractOrderController<CreatureOrder> {

    protected HunterController(OrderService<CreatureOrder> orderService) {
        super(orderService);
    }

}
