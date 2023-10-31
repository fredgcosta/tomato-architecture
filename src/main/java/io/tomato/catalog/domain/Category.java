package io.tomato.catalog.domain;

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
public class Category {

    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    private Set<Product> products;

    private Category parent;

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
