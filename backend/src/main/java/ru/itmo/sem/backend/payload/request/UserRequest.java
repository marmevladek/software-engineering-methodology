package ru.itmo.sem.backend.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Email must by valid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Patronymic is required")
    private String patronymic;

    @NotNull(message = "Role ID is required")
    private Long role;
}
