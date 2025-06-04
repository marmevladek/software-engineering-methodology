package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.model.user.Role;
import ru.itmo.sem.backend.model.user.User;
import ru.itmo.sem.backend.payload.request.UserRequest;
import ru.itmo.sem.backend.payload.response.UserResponse;

public class UserMapper {

    public static User toEntity(UserRequest userRequest, Role role) {
        return new User(
                userRequest.getEmail(),
                userRequest.getPassword(),
                userRequest.getSurname(),
                userRequest.getFirstName(),
                userRequest.getPatronymic(),
                role
        );
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getSurname(),
                user.getFirstName(),
                user.getPatronymic(),
                user.getRole().getName().name()
        );
    }
}
