package io.tomato.customer.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShoppingCart {
    @Id
    @OneToOne
    private Customer customer;

    @OneToMany
    private Set<ShoppingCartItem> items = new HashSet<>();
}
