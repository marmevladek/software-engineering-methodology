package ru.itmo.sem.backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itmo.sem.backend.payload.response.base.BaseOrderResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatureOrderResponse extends BaseOrderResponse {
    private String name;
}
