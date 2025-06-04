package ru.itmo.sem.backend.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.itmo.sem.backend.model.user.Role;
import ru.itmo.sem.backend.model.enums.RoleType;
import ru.itmo.sem.backend.repository.RoleRepository;

@Component
public class RoleInitializer implements ApplicationRunner {

    protected final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        for (RoleType roleType : RoleType.values()) {
            if (!roleRepository.existsByName(roleType)) {
                Role role = new Role();
                role.setName(roleType);
                roleRepository.save(role);
            }
        }
    }
}
