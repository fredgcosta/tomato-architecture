package io.tomato.customer.application.dtos;

import io.tomato.address.application.dtos.AddressDTO;
import io.tomato.customer.domain.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerAddressDTO {
    private CustomerDTO customer;
    private AddressDTO address;
    private AddressType addressType;
    private Boolean isPrincipal;
}
