package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.entity.Magic;

public interface MagicRepository extends JpaRepository<Magic, Long> {
}
