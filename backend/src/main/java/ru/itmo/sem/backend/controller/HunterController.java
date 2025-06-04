package ru.itmo.sem.backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.controller.base.AbstractOrderController;
import ru.itmo.sem.backend.dto.CreatureDTO;
import ru.itmo.sem.backend.model.order.CreatureOrder;
import ru.itmo.sem.backend.payload.request.ExhaustionOrderRequest;
import ru.itmo.sem.backend.payload.response.AvailabilityResponse;
import ru.itmo.sem.backend.payload.response.CreatureOrderResponse;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;
import ru.itmo.sem.backend.service.api.HunterService;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;

import java.util.List;


@RestController
@RequestMapping("/api/hunter")
@CrossOrigin("http://localhost:5173")
public class HunterController extends AbstractOrderController<CreatureOrder, CreatureOrderResponse> {

    private final HunterService hunterService;

    protected HunterController(BaseOrderService<CreatureOrder, CreatureOrderResponse> orderService, HunterService hunterService) {
        super(orderService);
        this.hunterService = hunterService;
    }

    @PostMapping("/order/create")
    public ResponseEntity<ExhaustionOrderResponse> createOrder(@Valid @RequestBody ExhaustionOrderRequest orderRequest) {
        return new ResponseEntity<>(hunterService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @PostMapping("/creature/add")
    public ResponseEntity<CreatureDTO> addCreature(@RequestBody CreatureDTO creatureDTO) {
        return new ResponseEntity<>(hunterService.addCreature(creatureDTO), HttpStatus.CREATED);
    }

    @GetMapping("/creatures/{id}/availability")
    public ResponseEntity<AvailabilityResponse> checkCreatureAvailability(
            @PathVariable Long id,
            @RequestParam int requestedQuantity
    ) {
        return new ResponseEntity<>(hunterService.checkAvailability(id, requestedQuantity), HttpStatus.OK);
    }

    @GetMapping("/my-orders")
    public ResponseEntity<List<ExhaustionOrderResponse>> findMyOrders() {
        return new ResponseEntity<>(hunterService.getMyOrders(), HttpStatus.OK);
    }
}
