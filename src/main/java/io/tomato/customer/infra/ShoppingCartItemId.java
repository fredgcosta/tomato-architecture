package io.tomato.customer.infra;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShoppingCartItemId implements Serializable {
    @Column(name = "customer_id")
    Long customerId;

    @Column(name = "product_id")
    Long productId;
}
