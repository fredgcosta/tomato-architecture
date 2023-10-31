package io.tomato.address.infra;

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
public class AddressId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private ZipCode zipCode;
    private Long number;
}
