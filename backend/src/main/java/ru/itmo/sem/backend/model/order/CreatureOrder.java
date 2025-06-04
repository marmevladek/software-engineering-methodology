package ru.itmo.sem.backend.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "creature_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatureOrder extends BaseOrder {
    private String name;
}
