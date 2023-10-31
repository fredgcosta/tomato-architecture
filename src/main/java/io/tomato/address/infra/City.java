package io.tomato.address.infra;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "city", schema = "tomato")
public class City {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private State state;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "id.city")
    private Set<ZipCode> zipCodes;

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
