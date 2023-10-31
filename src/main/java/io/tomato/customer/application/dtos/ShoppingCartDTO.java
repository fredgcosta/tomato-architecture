package io.tomato.customer.application.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingCartDTO {
    private Set<ShoppingCartItemDTO> items = new HashSet<>();
}
