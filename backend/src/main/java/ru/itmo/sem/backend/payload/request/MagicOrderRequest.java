package ru.itmo.sem.backend.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itmo.sem.backend.payload.request.base.BaseOrderRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MagicOrderRequest extends BaseOrderRequest {
    private Long magicId;
}
