package io.tomato.customer.infra;

import io.tomato.customer.domain.enums.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "END_CLI", schema = "tomato")
public class CustomerAddress {
    @EmbeddedId
    private CustomerAddressId id;

    @Column(name = "TIP_END")
    private AddressType addressType;

    private Boolean isPrincipal;
}
