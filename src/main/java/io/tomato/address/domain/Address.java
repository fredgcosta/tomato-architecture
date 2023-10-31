package io.tomato.address.domain;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    @EqualsAndHashCode.Include
    private ZipCode zipCode;
    @EqualsAndHashCode.Include
    private Long number;
    @Size(min = 0, max = 255, message = "Tamanho de complemento deve ter entre {min} e {max} caracteres")
    private String complement;
}
