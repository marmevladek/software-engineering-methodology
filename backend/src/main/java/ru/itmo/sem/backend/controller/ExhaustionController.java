package ru.itmo.sem.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.controller.base.AbstractOrderController;
import ru.itmo.sem.backend.dto.MagicDTO;
import ru.itmo.sem.backend.model.order.ExhaustionOrder;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;
import ru.itmo.sem.backend.service.api.ExhaustionService;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;


@RestController
@RequestMapping("/api/exhaustion")
@CrossOrigin("http://localhost:5173")
public class ExhaustionController extends AbstractOrderController<ExhaustionOrder, ExhaustionOrderResponse> {

    private final ExhaustionService exhaustionService;

    protected ExhaustionController(BaseOrderService<ExhaustionOrder, ExhaustionOrderResponse> orderService, ExhaustionService exhaustionService) {
        super(orderService);
        this.exhaustionService = exhaustionService;
    }

    @PutMapping("/magic/add")
    public ResponseEntity<MagicDTO> addMagic(@RequestBody MagicDTO magicDTO, @RequestParam String orderId) {
        return new ResponseEntity<>(exhaustionService.addMagic(magicDTO, orderId), HttpStatus.CREATED);
    }
}
