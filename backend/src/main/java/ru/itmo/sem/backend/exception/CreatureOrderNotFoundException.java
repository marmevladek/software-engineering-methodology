package ru.itmo.sem.backend.exception;

import java.util.UUID;

public class CreatureOrderNotFoundException extends RuntimeException {
    public CreatureOrderNotFoundException(UUID id) {
        super("CreatureOrder not found with id=" + id);
    }
}
