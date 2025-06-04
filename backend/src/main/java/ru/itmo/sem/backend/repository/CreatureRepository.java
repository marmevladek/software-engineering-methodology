package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.entity.Creature;

public interface CreatureRepository extends JpaRepository<Creature, Long> {
}
