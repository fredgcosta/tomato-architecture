package io.tomato.address.application.dtos;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Addresses")
public class AddressDTO {
    @EqualsAndHashCode.Include
    private ZipCodeDTO zipCode;
    @EqualsAndHashCode.Include
    private Long number;
    @Size(min = 0, max = 255, message = "Tamanho de complemento deve ter entre {min} e {max} caracteres")
    private String complement;
}

