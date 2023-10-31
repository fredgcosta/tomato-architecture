package io.tomato.customer.infra;

import io.tomato.address.infra.Address;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerAddressId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    Address address;
}
