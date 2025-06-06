package ru.itmo.sem.backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.sem.backend.controller.base.AbstractOrderController;
import ru.itmo.sem.backend.model.order.MagicOrder;
import ru.itmo.sem.backend.payload.request.CreatureOrderRequest;
import ru.itmo.sem.backend.payload.response.AvailabilityResponse;
import ru.itmo.sem.backend.payload.response.CreatureOrderResponse;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;
import ru.itmo.sem.backend.service.api.StorerService;

import java.util.List;


@RestController
@RequestMapping("/api/storer")
@CrossOrigin("http://localhost:5173")
public class StorerController extends AbstractOrderController<MagicOrder, MagicOrderResponse> {

    private final StorerService storerService;

    protected StorerController(BaseOrderService<MagicOrder, MagicOrderResponse> orderService, StorerService storerService) {
        super(orderService);
        this.storerService = storerService;
    }

    @PostMapping("/order/create")
    public ResponseEntity<CreatureOrderResponse> createOrder(@Valid @RequestBody CreatureOrderRequest orderRequest) {
        return new ResponseEntity<>(storerService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/magics/{id}/availability")
    public ResponseEntity<AvailabilityResponse> checkMagicAvailability(
            @PathVariable Long id,
            @RequestParam int requestedVolume
    ) {
        return new ResponseEntity<>(storerService.checkAvailability(id, requestedVolume), HttpStatus.OK);
    }

    @GetMapping("/my-orders")
    public ResponseEntity<List<CreatureOrderResponse>> findMyOrders() {
        return new ResponseEntity<>(storerService.getMyOrders(), HttpStatus.OK);
    }
}
