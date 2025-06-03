package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.MagicOrder;

import java.util.UUID;

public interface MagicOrderRepository extends JpaRepository<MagicOrder, UUID> {
}
