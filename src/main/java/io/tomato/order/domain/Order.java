package io.tomato.order.domain;

import io.tomato.customer.domain.Customer;
import io.tomato.order.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Customer customer;
    private Long number;
    private OrderStatus status;
    private Set<OrderItem> items;
}
