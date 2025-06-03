package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.CreatureOrder;

import java.util.UUID;

public interface CreatureOrderRepository extends JpaRepository<CreatureOrder, UUID> {
}
