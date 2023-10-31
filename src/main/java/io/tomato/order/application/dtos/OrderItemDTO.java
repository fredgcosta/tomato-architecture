package io.tomato.order.application.dtos;

import io.tomato.catalog.application.dtos.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {
    private OrderDTO order;
    private ProductDTO product;
    private Integer quantity;
}
