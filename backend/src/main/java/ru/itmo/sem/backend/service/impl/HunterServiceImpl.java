package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.dto.CreatureDTO;
import ru.itmo.sem.backend.exception.CreatureNotFoundException;
import ru.itmo.sem.backend.exception.CreatureOrderNotFoundException;
import ru.itmo.sem.backend.mapper.CreatureMapper;
import ru.itmo.sem.backend.mapper.CreatureOrderMapper;
import ru.itmo.sem.backend.mapper.ExhaustionOrderMapper;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.model.entity.Creature;
import ru.itmo.sem.backend.model.order.CreatureOrder;
import ru.itmo.sem.backend.model.order.ExhaustionOrder;
import ru.itmo.sem.backend.payload.request.ExhaustionOrderRequest;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.response.AvailabilityResponse;
import ru.itmo.sem.backend.payload.response.CreatureOrderResponse;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.repository.CreatureOrderRepository;
import ru.itmo.sem.backend.repository.CreatureRepository;
import ru.itmo.sem.backend.repository.ExhaustionOrderRepository;
import ru.itmo.sem.backend.service.api.HunterService;
import ru.itmo.sem.backend.service.common.AbstractOrderService;

import java.util.UUID;

@Service
public class HunterServiceImpl extends AbstractOrderService<CreatureOrder, CreatureOrderResponse> implements HunterService {

    private final ExhaustionOrderRepository exhaustionOrderRepository;
    private final CreatureRepository creatureRepository;


    public HunterServiceImpl(CreatureOrderRepository repository, ExhaustionOrderRepository exhaustionOrderRepository, CreatureRepository creatureRepository) {
        super(repository, CreatureOrderMapper::toResponse);
        this.exhaustionOrderRepository = exhaustionOrderRepository;
        this.creatureRepository = creatureRepository;
    }

    @Override
    protected RuntimeException createNotFoundException(UUID id) {
        return new CreatureOrderNotFoundException(id);
    }

    @Override
    public ExhaustionOrderResponse createOrder(ExhaustionOrderRequest orderRequest) {
        ExhaustionOrder order = ExhaustionOrderMapper.toEntity(orderRequest);
        ExhaustionOrder savedOrder = exhaustionOrderRepository.save(order);

        return ExhaustionOrderMapper.toResponse(savedOrder);
    }

    @Override
    public CreatureDTO addCreature(CreatureDTO creatureDTO) {
        Creature creature = CreatureMapper.toEntity(creatureDTO);
        Creature saved = creatureRepository.save(creature);

        return CreatureMapper.toDTO(saved);
    }

    @Override
    public AvailabilityResponse checkAvailability(Long id, int requestedQuantity) {
        Creature creature = creatureRepository.findById(id)
                .orElseThrow(() -> new CreatureNotFoundException(id));

        return new AvailabilityResponse(creature.getQuantity() >= requestedQuantity);
    }
}
