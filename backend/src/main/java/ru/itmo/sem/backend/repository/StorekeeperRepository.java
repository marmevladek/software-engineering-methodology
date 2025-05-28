package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.Storekeeper;

public interface StorekeeperRepository extends JpaRepository<Storekeeper, Long> {
}
