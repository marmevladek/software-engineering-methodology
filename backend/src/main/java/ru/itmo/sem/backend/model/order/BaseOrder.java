package ru.itmo.sem.backend.model.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itmo.sem.backend.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "title")
    private String title;

    @Column(name = "deadline")
    private String deadline; // localdatetime

    @Column(name = "quantity")
    private int quantity;

    public BaseOrder(LocalDateTime createdAt, OrderStatus status, String title, String deadline, int quantity) {
        this.createdAt = createdAt;
        this.status = status;
        this.title = title;
        this.deadline = deadline;
        this.quantity = quantity;
    }
}
