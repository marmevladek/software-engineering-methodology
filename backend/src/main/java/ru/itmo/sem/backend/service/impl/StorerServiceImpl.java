package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.MagicNotFoundException;
import ru.itmo.sem.backend.exception.MagicOrderNotFoundException;
import ru.itmo.sem.backend.mapper.CreatureOrderMapper;
import ru.itmo.sem.backend.mapper.MagicOrderMapper;
import ru.itmo.sem.backend.model.entity.Magic;
import ru.itmo.sem.backend.model.order.CreatureOrder;
import ru.itmo.sem.backend.model.order.MagicOrder;
import ru.itmo.sem.backend.payload.request.CreatureOrderRequest;
import ru.itmo.sem.backend.payload.response.*;
import ru.itmo.sem.backend.repository.CreatureOrderRepository;
import ru.itmo.sem.backend.repository.MagicOrderRepository;
import ru.itmo.sem.backend.repository.MagicRepository;
import ru.itmo.sem.backend.service.api.StorerService;
import ru.itmo.sem.backend.service.common.AbstractOrderService;

import java.util.List;
import java.util.UUID;

@Service
public class StorerServiceImpl extends AbstractOrderService<MagicOrder, MagicOrderResponse> implements StorerService {

    private final CreatureOrderRepository creatureOrderRepository;
    private final MagicRepository magicRepository;

    protected StorerServiceImpl(MagicOrderRepository repository, CreatureOrderRepository creatureOrderRepository, MagicRepository magicRepository) {
        super(repository, MagicOrderMapper::toResponse);
        this.creatureOrderRepository = creatureOrderRepository;
        this.magicRepository = magicRepository;
    }

    @Override
    protected RuntimeException createNotFoundException(UUID id) {
        return new MagicOrderNotFoundException(id);
    }


    @Override
    public CreatureOrderResponse createOrder(CreatureOrderRequest orderRequest) {
        CreatureOrder order = CreatureOrderMapper.toEntity(orderRequest);
        CreatureOrder savedOrder = creatureOrderRepository.save(order);

        return CreatureOrderMapper.toResponse(savedOrder);
    }

    @Override
    public AvailabilityResponse checkAvailability(Long id, int requestedVolume) {
        Magic magic = magicRepository.findById(id)
                .orElseThrow(() -> new MagicNotFoundException(id));

        return new AvailabilityResponse(magic.getVolume() >= requestedVolume);
    }

    @Override
    public List<CreatureOrderResponse> getMyOrders() {
        return creatureOrderRepository.findAll()
                .stream()
                .map(CreatureOrderMapper::toResponse)
                .toList();
    }
}
