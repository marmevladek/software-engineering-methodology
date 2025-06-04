package ru.itmo.sem.backend.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.itmo.sem.backend.model.entity.Creature;
import ru.itmo.sem.backend.repository.CreatureRepository;

@Component
public class CreatureInitializer implements ApplicationRunner {

    protected final CreatureRepository creatureRepository;

    public CreatureInitializer(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        int quantity = 6;
        for (int i = 1; i <= 5; i++) {
            creatureRepository.save(
                    new Creature(
                            (long) i,
                            "name-" + i,
                            "place-" + i,
                            quantity
                    )
            );

            quantity += 6;
        }
    }
}
