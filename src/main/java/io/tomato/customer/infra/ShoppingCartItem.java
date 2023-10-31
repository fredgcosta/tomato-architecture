package io.tomato.customer.infra;

import io.tomato.catalog.infra.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shopping-cart-item", schema = "tomato")
public class ShoppingCartItem {
    @EmbeddedId
    ShoppingCartItemId id;

    @MapsId("customerId")
    @ManyToOne
    Customer customer;

    @MapsId("productId")
    @ManyToOne
    Product product;

    private Integer quantity;
}
