package ru.itmo.sem.backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "creatures")
@Getter
@Setter
@NoArgsConstructor
public class Creature {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "storage_place")
    private String storagePlace;

    @Column(name = "quantity")
    private int quantity;

    public Creature(Long id, String name, String storagePlace, int quantity) {
        this.id = id;
        this.name = name;
        this.storagePlace = storagePlace;
        this.quantity = quantity;
    }
}
