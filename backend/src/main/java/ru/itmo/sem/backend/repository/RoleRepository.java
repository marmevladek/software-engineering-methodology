package ru.itmo.sem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.sem.backend.model.Role;
import ru.itmo.sem.backend.model.enums.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(RoleType roleType);
}
