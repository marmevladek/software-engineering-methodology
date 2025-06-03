package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.CreatureOrderNotFoundException;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.model.CreatureOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.repository.CreatureOrderRepository;
import ru.itmo.sem.backend.service.api.HunterService;
import ru.itmo.sem.backend.service.common.AbstractOrderService;

import java.util.UUID;

@Service
public class HunterServiceImpl extends AbstractOrderService<CreatureOrder> implements HunterService {

    public HunterServiceImpl(CreatureOrderRepository repository) {
        super(repository);
    }

    @Override
    protected RuntimeException createNotFoundException(UUID id) {
        return new CreatureOrderNotFoundException(id);
    }
}
