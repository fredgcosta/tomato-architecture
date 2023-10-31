package io.tomato.address.domain;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Country {
    @EqualsAndHashCode.Include
    private Long id;

    @Size(min = 3, max = 40, message = "Tamanho de país deve ter entre {min} e {max} caracteres")
    private String name;

    @Size(min = 2, max = 2, message = "Tamanho de state deve ter {max} caracteres")
    private String iso;

    @Size(min = 3, max = 3, message = "Tamanho de state deve ter {max} caracteres")
    private String iso3;
    private Set<State> states;

    private Integer numcode;
    private Integer phonecode;
}
