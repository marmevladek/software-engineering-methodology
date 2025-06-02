package ru.itmo.sem.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itmo.sem.backend.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "magic_orders")
@Getter
@Setter
@NoArgsConstructor
public class MagicOrder {

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

    public MagicOrder(LocalDateTime createdAt, OrderStatus status, String title) {
        this.createdAt = createdAt;
        this.status = status;
        this.title = title;
    }
}
