package io.tomato.address.infra;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "tomato")
public class Address {
    @EmbeddedId
    private AddressId id;

    @Size(min = 0, max = 255, message = "Tamanho de complemento deve ter entre {min} e {max} caracteres")
    private String complement;

    public Address(AddressId id, String complement) {
        this.id = id;
        this.complement = complement;
    }
}
