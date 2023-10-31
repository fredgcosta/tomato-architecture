package io.tomato.customer.domain;

import io.tomato.catalog.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingCartItem {
    private Customer customer;
    private Product product;
    private Integer quantity;
}
