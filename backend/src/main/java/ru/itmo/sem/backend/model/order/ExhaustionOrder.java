package ru.itmo.sem.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "exhaustion_orders")
public class ExhaustionOrder extends BaseOrder{
}
