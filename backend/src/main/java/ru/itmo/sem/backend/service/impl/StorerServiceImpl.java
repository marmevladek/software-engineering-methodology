package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.MagicOrderNotFoundException;
import ru.itmo.sem.backend.model.MagicOrder;
import ru.itmo.sem.backend.repository.MagicOrderRepository;
import ru.itmo.sem.backend.service.api.StorerService;
import ru.itmo.sem.backend.service.common.AbstractOrderService;

import java.util.UUID;

@Service
public class StorerServiceImpl extends AbstractOrderService<MagicOrder> implements StorerService {


    protected StorerServiceImpl(MagicOrderRepository repository) {
        super(repository);
    }

    @Override
    protected RuntimeException createNotFoundException(UUID id) {
        return new MagicOrderNotFoundException(id);
    }
}
