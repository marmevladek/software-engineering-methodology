package ru.itmo.sem.backend.exception;

public class CreatureNotFoundException extends RuntimeException {
    public CreatureNotFoundException(Long id) {
        super("Creature not found with id=" + id);
    }
}
