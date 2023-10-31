package io.tomato.catalog.domain;

import io.tomato.customer.domain.ShoppingCartItem;
import io.tomato.order.domain.OrderItem;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Category category;
    private Set<ShoppingCartItem> shoppingCartItems;
    private Set<OrderItem> orderItems;
    private BigDecimal price;
}
