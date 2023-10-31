package io.tomato.address.application.dtos;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "ZipCodes")
public class ZipCodeDTO implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Include
    private CityDTO city;
    @Size(min = 3, max = 255, message = "Tamanho de street deve ter entre {min} e {max} caracteres")
    private String street;
    @Size(min = 3, max = 255, message = "Tamanho de street deve ter entre {min} e {max} caracteres")
    private String neighborhood;
    private Set<AddressDTO> addresses;
}


