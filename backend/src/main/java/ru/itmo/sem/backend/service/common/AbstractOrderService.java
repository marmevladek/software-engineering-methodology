package ru.itmo.sem.backend.service.common;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.model.BaseOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.service.api.OrderService;

import java.util.List;
import java.util.UUID;

public abstract class AbstractOrderService<T extends BaseOrder> implements OrderService<T> {

    protected final JpaRepository<T, UUID> repository;

    protected AbstractOrderService(JpaRepository<T, UUID> repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(GenericOrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponse findById(UUID id) {
        T order = repository.findById(id)
                .orElseThrow(() -> createNotFoundException(id));
        return GenericOrderMapper.toResponse(order);
    }

    @Override
    public void processOrder(UUID id) {
        T order = repository.findById(id)
                .orElseThrow(() -> createNotFoundException(id));

        if (!order.getStatus().equals(OrderStatus.IN_PROGRESS)) {
            order.setStatus(OrderStatus.IN_PROGRESS);
            repository.save(order);
        } else {
            repository.delete(order);
        }
    }

    protected abstract RuntimeException createNotFoundException(UUID id);
}
