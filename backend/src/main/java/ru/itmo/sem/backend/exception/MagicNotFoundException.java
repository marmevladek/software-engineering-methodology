package ru.itmo.sem.backend.exception;

public class MagicNotFoundException extends RuntimeException {
    public MagicNotFoundException(Long id) {
        super("Magic not found with id=" + id);
    }
}
