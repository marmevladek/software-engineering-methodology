package ru.itmo.sem.backend.exception;

import java.util.UUID;

public class MagicOrderNotFoundException extends RuntimeException {
    public MagicOrderNotFoundException(UUID id) {
        super("MagicOrder not found with id=" + id);
    }
}
