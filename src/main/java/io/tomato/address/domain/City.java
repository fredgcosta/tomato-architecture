package io.tomato.address.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Include
    private State state;
    private String name;

    private Set<ZipCode> zipCodes;

}
