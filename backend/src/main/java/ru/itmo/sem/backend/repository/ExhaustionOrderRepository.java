package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.order.ExhaustionOrder;

import java.util.UUID;

public interface ExhaustionOrderRepository extends JpaRepository<ExhaustionOrder, UUID> {
}
