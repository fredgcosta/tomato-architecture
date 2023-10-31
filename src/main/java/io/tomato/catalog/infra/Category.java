package io.tomato.catalog.infra;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "category", schema = "tomato")
public class Category {

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 3
    )
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Set<Category> subCategories = new HashSet<>();

    public Category addSubCategory(String categoryName) {
        Category sub = new Category();
        sub.setName(categoryName);
        this.subCategories.add(sub);
        sub.setParent(this);
        return sub;
    }

    public void moveSubCategory(Category newParentCategory) {
        this.getParent().getSubCategories().remove(this);
        this.setParent(newParentCategory);
        newParentCategory.getSubCategories().add(this);
    }
}
