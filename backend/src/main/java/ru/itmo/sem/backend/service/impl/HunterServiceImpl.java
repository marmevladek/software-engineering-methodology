package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.CreatureOrderNotFoundException;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.model.CreatureOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.repository.CreatureOrderRepository;
import ru.itmo.sem.backend.service.HunterService;

import java.util.List;
import java.util.UUID;

@Service
public class HunterServiceImpl implements HunterService {

    private final CreatureOrderRepository creatureOrderRepository;

    public HunterServiceImpl(CreatureOrderRepository creatureOrderRepository) {
        this.creatureOrderRepository = creatureOrderRepository;
    }


    @Override
    public List<OrderResponse> findAll() {
        return creatureOrderRepository.findAll()
                .stream()
                .map(GenericOrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponse findById(UUID id) {
        CreatureOrder order = creatureOrderRepository.findById(id)
                .orElseThrow(() -> new CreatureOrderNotFoundException(id));
        return GenericOrderMapper.toResponse(order);
    }

    @Override
    public void processOrder(UUID id) {
        CreatureOrder order = creatureOrderRepository.findById(id)
                .orElseThrow(() -> new CreatureOrderNotFoundException(id));

        if (!order.getStatus().equals(OrderStatus.IN_PROGRESS)) {
            order.setStatus(OrderStatus.IN_PROGRESS);
            creatureOrderRepository.save(order);
        } else {
            creatureOrderRepository.delete(order);
        }
    }
}
