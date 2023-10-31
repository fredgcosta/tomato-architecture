package io.tomato.address.infra;

import jakarta.persistence.*;
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
@Entity
@Table(name = "country", schema = "tomato")
public class Country {
    public Integer numcode;
    public Integer phonecode;
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    @Column(unique = true)
    @Size(min = 3, max = 40, message = "Tamanho de país deve ter entre {min} e {max} caracteres")
    private String name;
    @Column(length = 2, unique = true)
    @Size(min = 2, max = 2, message = "Tamanho de state deve ter {max} caracteres")
    private String iso;
    @Column(length = 3, unique = true)
    @Size(min = 3, max = 3, message = "Tamanho de state deve ter {max} caracteres")
    private String iso3;
    @OneToMany(mappedBy = "id.country")
    private Set<State> states;
}
