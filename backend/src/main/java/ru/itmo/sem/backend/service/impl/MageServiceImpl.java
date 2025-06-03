package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.RoleNotFoundException;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.mapper.UserMapper;
import ru.itmo.sem.backend.model.MagicOrder;
import ru.itmo.sem.backend.model.Role;
import ru.itmo.sem.backend.model.User;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;
import ru.itmo.sem.backend.repository.MagicOrderRepository;
import ru.itmo.sem.backend.repository.RoleRepository;
import ru.itmo.sem.backend.repository.UserRepository;
import ru.itmo.sem.backend.service.MageService;

@Service
public class MageServiceImpl implements MageService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MagicOrderRepository magicOrderRepository;

    public MageServiceImpl(UserRepository userRepository, RoleRepository roleRepository, MagicOrderRepository magicOrderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.magicOrderRepository = magicOrderRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        Role role = roleRepository.findById(userRequest.getRole())
                .orElseThrow(() -> new RoleNotFoundException(userRequest.getRole()));

        User user = UserMapper.toEntity(userRequest, role);
        User savedUser = userRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }

    @Override
    public OrderResponse createMagicOrder(OrderRequest orderRequest) {
        MagicOrder order = GenericOrderMapper.toEntity(orderRequest, MagicOrder::new);
        MagicOrder savedOrder = magicOrderRepository.save(order);

        return GenericOrderMapper.toResponse(savedOrder);
    }
}
