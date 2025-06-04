package ru.itmo.sem.backend.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.sem.backend.exception.RoleNotFoundException;
import ru.itmo.sem.backend.mapper.GenericOrderMapper;
import ru.itmo.sem.backend.mapper.MagicOrderMapper;
import ru.itmo.sem.backend.mapper.UserMapper;
import ru.itmo.sem.backend.model.order.MagicOrder;
import ru.itmo.sem.backend.model.user.Role;
import ru.itmo.sem.backend.model.user.User;
import ru.itmo.sem.backend.payload.request.MagicOrderRequest;
import ru.itmo.sem.backend.payload.request.OrderRequest;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.MagicOrderResponse;
import ru.itmo.sem.backend.payload.response.OrderResponse;
import ru.itmo.sem.backend.payload.response.UserResponse;
import ru.itmo.sem.backend.repository.MagicOrderRepository;
import ru.itmo.sem.backend.repository.RoleRepository;
import ru.itmo.sem.backend.repository.UserRepository;
import ru.itmo.sem.backend.service.api.MageService;

import java.util.List;
import java.util.stream.Collectors;

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
    public MagicOrderResponse createMagicOrder(MagicOrderRequest orderRequest) {
        MagicOrder order = MagicOrderMapper.toEntity(orderRequest);
        MagicOrder savedOrder = magicOrderRepository.save(order);

        return MagicOrderMapper.toResponse(savedOrder);
    }

    @Override
    public List<MagicOrderResponse> findAllOrders() {
        List<MagicOrder> orders = magicOrderRepository.findAll();

        return orders.stream().map(MagicOrderMapper::toResponse).collect(Collectors.toList());
    }
}
