package io.tomato.customer.domain;

import io.tomato.address.domain.Address;
import io.tomato.customer.domain.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerAddress {
    private Customer customer;
    private Address address;
    private AddressType addressType;
    private Boolean isPrincipal;
}
