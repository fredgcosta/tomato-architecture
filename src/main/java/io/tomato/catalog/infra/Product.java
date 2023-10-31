package io.tomato.catalog.infra;

import io.tomato.customer.infra.ShoppingCartItem;
import io.tomato.order.infra.OrderItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Entity
@Table(name = "product", schema = "tomato")
public class Product {

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ShoppingCartItem> shoppingCartItems;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> itemsOrderCustomer;

    private BigDecimal price;
}
