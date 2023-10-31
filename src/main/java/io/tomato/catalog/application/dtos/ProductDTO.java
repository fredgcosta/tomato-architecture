package io.tomato.catalog.application.dtos;

import io.tomato.customer.application.dtos.ShoppingCartItemDTO;
import io.tomato.order.application.dtos.OrderItemDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Products")
public class ProductDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private CategoryDTO category;
    private Set<ShoppingCartItemDTO> shoppingCartItems;
    private Set<OrderItemDTO> orderItems;
    private BigDecimal price;
}
