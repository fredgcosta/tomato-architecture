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
@Entity
@Table(name = "state", schema = "tomato")
public class State {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "state_sequence"
    )
    @SequenceGenerator(
            name = "state_sequence",
            sequenceName = "state_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @Column(unique = true)
    @Size(min = 3, max = 40, message = "Tamanho de state deve ter entre {min} e {max} caracteres")
    private String name;
    @Column(unique = true)
    @Size(min = 2, max = 2, message = "Tamanho de state deve ter {max} caracteres")
    private String code;

    @OneToMany(mappedBy = "id.state")
    private Set<City> cities;

}
