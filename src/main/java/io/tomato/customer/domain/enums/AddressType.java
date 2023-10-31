package io.tomato.customer.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true, chain = false)
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AddressType {
    ENDERECO_COBRANCA(1),
    ENDERECO_ENTREGA(2);

    private final Integer id;
}
