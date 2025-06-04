package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.dto.CreatureDTO;
import ru.itmo.sem.backend.model.entity.Creature;

public class CreatureMapper {

    public static Creature toEntity(CreatureDTO creatureRequest) {
        return new Creature(
                creatureRequest.getId(),
                creatureRequest.getName(),
                creatureRequest.getStoragePlace(),
                creatureRequest.getQuantity()
        );
    }

    public static CreatureDTO toDTO(Creature creature) {
        return new CreatureDTO(
                creature.getId(),
                creature.getName(),
                creature.getStoragePlace(),
                creature.getQuantity()
        );
    }
}
