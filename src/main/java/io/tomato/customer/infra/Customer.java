package io.tomato.customer.infra;

import io.tomato.order.infra.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customer", schema = "tomato")
public class Customer {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @OneToOne
    private ShoppingCartItem shoppingCart;

    @OneToMany(mappedBy = "id.customer")
    private Set<CustomerAddress> customerAddress;

    @OneToMany(mappedBy = "id.customer")
    private Set<Order> orders;
}
