package ru.itmo.sem.backend.service.common;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.order.BaseOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.response.base.BaseOrderResponse;
import ru.itmo.sem.backend.service.api.base.BaseOrderService;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public abstract class AbstractOrderService<T extends BaseOrder, R extends BaseOrderResponse> implements BaseOrderService<T, R> {

    protected final JpaRepository<T, UUID> repository;
    protected final Function<T, R> toResponse;

    protected AbstractOrderService(JpaRepository<T, UUID> repository, Function<T, R> toResponse) {
        this.repository = repository;
        this.toResponse = toResponse;
    }

    @Override
    public List<R> findAll() {
        return repository.findAll()
                .stream()
                .map(toResponse)
                .toList();
    }

    @Override
    public R findById(UUID id) {
        T order = repository.findById(id)
                .orElseThrow(() -> createNotFoundException(id));
        return toResponse.apply(order);
    }

    @Override
    public void completedOrder(UUID id) {
        T order = repository.findById(id)
                .orElseThrow(() -> createNotFoundException(id));

        if (order.getStatus().equals(OrderStatus.IN_PROGRESS)) {
            order.setStatus(OrderStatus.DONE);
            repository.save(order);
        }
    }

    protected abstract RuntimeException createNotFoundException(UUID id);
}
