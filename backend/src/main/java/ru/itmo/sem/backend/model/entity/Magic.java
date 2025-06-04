package ru.itmo.sem.backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "magics")
@Getter
@Setter
@NoArgsConstructor
public class Magic {

    @Id
    private Long id;

    @Column(name = "volume")
    private int volume;

    public Magic(Long id, int volume) {
        this.id = id;
        this.volume = volume;
    }
}
