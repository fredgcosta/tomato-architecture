package io.tomato.order.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true, chain = false)
public enum OrderStatus {
    ORDERED(1),
    READY(2),
    DELIVERED(3);
    private final Integer id;
}
