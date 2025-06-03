package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
