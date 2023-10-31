package io.tomato.customer.application.dtos;

import io.tomato.order.application.dtos.OrderDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Customer")
public class CustomerDTO {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String name;
    private Set<ShoppingCartItemDTO> shoppingCartItems = new HashSet<>();
    private Set<CustomerAddressDTO> customerAddress;
    private Set<OrderDTO> orders;
}
