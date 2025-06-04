package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.dto.MagicDTO;
import ru.itmo.sem.backend.exception.ExhaustionOrderNotFoundException;
import ru.itmo.sem.backend.mapper.ExhaustionOrderMapper;
import ru.itmo.sem.backend.mapper.MagicMapper;
import ru.itmo.sem.backend.model.entity.Magic;
import ru.itmo.sem.backend.model.order.ExhaustionOrder;
import ru.itmo.sem.backend.payload.response.ExhaustionOrderResponse;
import ru.itmo.sem.backend.repository.ExhaustionOrderRepository;
import ru.itmo.sem.backend.repository.MagicRepository;
import ru.itmo.sem.backend.service.api.ExhaustionService;
import ru.itmo.sem.backend.service.common.AbstractOrderService;

import java.util.UUID;

@Service
public class ExhaustionServiceImpl extends AbstractOrderService<ExhaustionOrder, ExhaustionOrderResponse> implements ExhaustionService {

    private final MagicRepository magicRepository;

    protected ExhaustionServiceImpl(ExhaustionOrderRepository repository, MagicRepository magicRepository) {
        super(repository, ExhaustionOrderMapper::toResponse);
        this.magicRepository = magicRepository;
    }

    @Override
    protected RuntimeException createNotFoundException(UUID id) {
        return new ExhaustionOrderNotFoundException(id);
    }

    @Override
    public MagicDTO addMagic(MagicDTO magicDTO) {
        Magic magic = MagicMapper.toEntity(magicDTO);
        Magic saved = magicRepository.save(magic);

        return MagicMapper.toDTO(saved);
    }
}
