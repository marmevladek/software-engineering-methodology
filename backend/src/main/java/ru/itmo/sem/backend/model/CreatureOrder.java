package ru.itmo.sem.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "creature_orders")
public class CreatureOrder extends BaseOrder {
}
