package ru.itmo.sem.backend.mapper;

import ru.itmo.sem.backend.dto.MagicDTO;
import ru.itmo.sem.backend.model.entity.Magic;

public class MagicMapper {

    public static Magic toEntity(MagicDTO magicRequest) {
        return new Magic(
                magicRequest.getId(),
                magicRequest.getVolume()
        );
    }

    public static MagicDTO toDTO(Magic magic) {
        return new MagicDTO(
                magic.getId(),
                magic.getVolume()
        );
    }
}
