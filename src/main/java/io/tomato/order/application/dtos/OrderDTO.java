package io.tomato.order.application.dtos;

import io.tomato.customer.application.dtos.CustomerDTO;
import io.tomato.order.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Orders")
public class OrderDTO {
    private CustomerDTO customer;
    private Long number;
    private OrderStatus status;
    private Set<OrderItemDTO> items;
}
