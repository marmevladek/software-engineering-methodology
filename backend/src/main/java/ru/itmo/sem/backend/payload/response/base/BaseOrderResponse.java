package ru.itmo.sem.backend.payload.response.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itmo.sem.backend.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseOrderResponse {
    private UUID id;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private String title;
    private String deadline; // localdatetime
    private int quantity;
}
