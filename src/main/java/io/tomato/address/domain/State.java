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
public class State {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Include
    private Country country;

    @Size(min = 3, max = 40, message = "Tamanho de state deve ter entre {min} e {max} caracteres")
    private String name;
    @Size(min = 2, max = 2, message = "Tamanho de state deve ter {max} caracteres")
    private String code;
    private Set<City> cities;
}
