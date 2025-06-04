package ru.itmo.sem.backend.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.itmo.sem.backend.model.entity.Magic;
import ru.itmo.sem.backend.repository.MagicRepository;

@Component
public class MagicInitializer implements ApplicationRunner {

    protected final MagicRepository magicRepository;

    public MagicInitializer(MagicRepository magicRepository) {
        this.magicRepository = magicRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        int volume = 10;
        for (int i = 1; i <= 5; i++) {
            if (!magicRepository.existsById((long)i)) {
                magicRepository.save(
                        new Magic(
                                (long) i,
                                volume
                        )
                );

                volume += 4;
            }
        }
    }

}
