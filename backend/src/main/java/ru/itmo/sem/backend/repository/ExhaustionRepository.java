package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.Exhaustion;

public interface ExhaustionRepository extends JpaRepository<Exhaustion, Long> {
}
