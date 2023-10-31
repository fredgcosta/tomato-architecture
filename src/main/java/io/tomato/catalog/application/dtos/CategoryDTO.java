package io.tomato.catalog.application.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Categories de Product")
public class CategoryDTO {

    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @JsonIgnore
    private Set<ProductDTO> products;

    private CategoryDTO parent;

    @JsonIgnore
    private Set<CategoryDTO> subCategories = new HashSet<>();

    public CategoryDTO addSubCategory(String name) {
        CategoryDTO sub = new CategoryDTO();
        sub.setName(name);
        this.subCategories.add(sub);
        sub.setParent(this);
        return sub;
    }

    public void moveSubCategory(CategoryDTO newParentCategory) {
        this.getParent().getSubCategories().remove(this);
        this.setParent(newParentCategory);
        newParentCategory.getSubCategories().add(this);
    }
}
