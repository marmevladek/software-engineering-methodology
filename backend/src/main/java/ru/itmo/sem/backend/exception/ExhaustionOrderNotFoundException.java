package ru.itmo.sem.backend.exception;

import java.util.UUID;

public class ExhaustionOrderNotFoundException extends RuntimeException {
    public ExhaustionOrderNotFoundException(UUID id) {
        super("Exhaustion Order not found with id=" + id);
    }
}
