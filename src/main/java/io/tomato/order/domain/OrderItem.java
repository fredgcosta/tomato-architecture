package io.tomato.order.domain;

import io.tomato.catalog.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    private Order order;
    private Product product;
    private Integer quantity;
}
