package io.tomato.address.application.dtos;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Countries")
public class CountryDTO {
    public Integer numcode;
    public Integer phonecode;
    @EqualsAndHashCode.Include
    private Long id;
    @Size(min = 3, max = 40, message = "Tamanho de país deve ter entre {min} e {max} caracteres")
    private String name;
    @Size(min = 2, max = 2, message = "Tamanho de state deve ter {max} caracteres")
    private String iso;
    @Size(min = 3, max = 3, message = "Tamanho de state deve ter {max} caracteres")
    private String iso3;
    private Set<StateDTO> states;
}
