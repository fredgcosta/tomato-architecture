package io.tomato.customer.application.dtos;

import io.tomato.catalog.application.dtos.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingCartItemDTO {
    private CustomerDTO customer;
    private ProductDTO product;
    private Integer quantity;
}
