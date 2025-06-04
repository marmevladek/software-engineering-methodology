package ru.itmo.sem.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itmo.sem.backend.payload.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

  @ExceptionHandler(RoleNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleRoleNotFound(RoleNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
            "ROLE_NOT_FOUND",
            ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(MagicOrderNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleMagicOrderNotFound(MagicOrderNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
            "MAGIC_ORDER_NOT_FOUND",
            ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(CreatureOrderNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleCreatureOrderNotFound(CreatureOrderNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
            "CREATURE_ORDER_NOT_FOUND",
            ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(ExhaustionOrderNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleExhaustionOrderNotFound(ExhaustionOrderNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
            "EXHAUSTION_ORDER_NOT_FOUND",
            ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(MagicNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleMagicNotFound(MagicNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
            "MAGIC_NOT_FOUND",
            ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(CreatureNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleCreatureNotFound(CreatureNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
            "CREATURE_NOT_FOUND",
            ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
