package io.tomato.address.application.dtos;

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
@Schema(description = "Cities")
public class CityDTO {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Include
    private StateDTO state;
    private String name;
    private Set<ZipCodeDTO> zipCodes;

}
