package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.Magician;

public interface MagicianRepository extends JpaRepository<Magician, Long> {
}
