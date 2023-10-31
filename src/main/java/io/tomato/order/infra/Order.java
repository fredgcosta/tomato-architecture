package io.tomato.order.infra;

import io.tomato.customer.infra.Customer;
import io.tomato.order.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order", schema = "tomato")
public class Order {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 3
    )
    @Id
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.order")
    private Set<OrderItem> items;
}
