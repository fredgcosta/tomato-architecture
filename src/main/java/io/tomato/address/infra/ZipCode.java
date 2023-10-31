package io.tomato.address.infra;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "zipCode", schema = "tomato")
public class ZipCode implements Serializable {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "zipcode_sequence"
    )
    @SequenceGenerator(
            name = "zipcode_sequence",
            sequenceName = "zipcode_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
    @Size(min = 3, max = 255, message = "Tamanho de street deve ter entre {min} e {max} caracteres")
    private String street;
    @Size(min = 3, max = 255, message = "Tamanho de street deve ter entre {min} e {max} caracteres")
    private String neighborhood;
    @OneToMany(mappedBy = "id.zipCode")
    private Set<Address> addresses;
}


