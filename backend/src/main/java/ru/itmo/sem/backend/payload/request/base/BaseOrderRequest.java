package ru.itmo.sem.backend.payload.request.base;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseOrderRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String deadline; // localdatetime

    private int quantity;
}
