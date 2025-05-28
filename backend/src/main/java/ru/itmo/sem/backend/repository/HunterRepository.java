package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.Hunter;

public interface HunterRepository extends JpaRepository<Hunter, Long> {
}
