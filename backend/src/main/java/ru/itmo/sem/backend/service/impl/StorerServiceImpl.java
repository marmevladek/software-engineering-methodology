package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.MagicOrderNotFoundException;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.model.MagicOrder;
import ru.itmo.sem.backend.model.enums.OrderStatus;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.repository.MagicOrderRepository;
import ru.itmo.sem.backend.service.StorerService;

import java.util.List;
import java.util.UUID;

@Service
public class StorerServiceImpl implements StorerService {

    private final MagicOrderRepository magicOrderRepository;

    public StorerServiceImpl(MagicOrderRepository magicOrderRepository) {
        this.magicOrderRepository = magicOrderRepository;
    }

    @Override
    public List<OrderResponse> findAll() {
        return magicOrderRepository.findAll()
                .stream()
                .map(GenericOrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponse findById(UUID id) {
        MagicOrder order = magicOrderRepository.findById(id)
                .orElseThrow(() -> new MagicOrderNotFoundException(id));
        return GenericOrderMapper.toResponse(order);
    }

    @Override
    public void processOrder(UUID id) {
        MagicOrder order = magicOrderRepository.findById(id)
                .orElseThrow(() -> new MagicOrderNotFoundException(id));

        if (!order.getStatus().equals(OrderStatus.IN_PROGRESS)) {
            order.setStatus(OrderStatus.IN_PROGRESS);
            magicOrderRepository.save(order);
        } else {
            magicOrderRepository.delete(order);
        }
    }
}
