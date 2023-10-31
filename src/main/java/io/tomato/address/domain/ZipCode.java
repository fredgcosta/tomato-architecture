package io.tomato.address.domain;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ZipCode implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Include
    private City city;

    @Size(min = 3, max = 255, message = "Tamanho de street deve ter entre {min} e {max} caracteres")
    private String street;
    @Size(min = 3, max = 255, message = "Tamanho de street deve ter entre {min} e {max} caracteres")
    private String neighborhood;
    private Set<Address> addresses;
}


