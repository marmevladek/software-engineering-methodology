package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.ExhaustionOrderNotFoundException;
import ru.itmo.sem.backend.model.ExhaustionOrder;
import ru.itmo.sem.backend.repository.ExhaustionOrderRepository;
import ru.itmo.sem.backend.service.api.ExhaustionService;
import ru.itmo.sem.backend.service.common.AbstractOrderService;

import java.util.UUID;

@Service
public class ExhaustionServiceImpl extends AbstractOrderService<ExhaustionOrder> implements ExhaustionService {

    protected ExhaustionServiceImpl(ExhaustionOrderRepository repository) {
        super(repository);
    }

    @Override
    protected RuntimeException createNotFoundException(UUID id) {
        return new ExhaustionOrderNotFoundException(id);
    }
}
