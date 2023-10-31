package io.tomato.customer.domain;

import io.tomato.order.domain.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String name;
    private Set<ShoppingCartItem> shoppingCartItems = new HashSet<>();
    private Set<CustomerAddress> customerAddress;
    private Set<Order> orders;
}
