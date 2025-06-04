package ru.itmo.sem.backend.model.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "magic_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MagicOrder extends BaseOrder {
    private Long magicId;
}
