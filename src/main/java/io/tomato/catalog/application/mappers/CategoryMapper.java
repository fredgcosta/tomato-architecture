package io.tomato.catalog.application.mappers;

import io.tomato.catalog.application.dtos.CategoryDTO;
import io.tomato.catalog.infra.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface CategoryMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "parent", target = "parent")
    @Mapping(source = "subCategories", target = "subCategories")
    io.tomato.catalog.domain.Category dtoToDomain(CategoryDTO dto);

    List<io.tomato.catalog.domain.Category> dtoListToDomainList(List<CategoryDTO> dtos);

    @InheritInverseConfiguration
    CategoryDTO domainToDto(io.tomato.catalog.domain.Category category);

    @InheritInverseConfiguration
    List<CategoryDTO> domainListToDtoList(List<io.tomato.catalog.domain.Category> categories);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "subCategories", target = "subCategories")
    Category domainToEntity(io.tomato.catalog.domain.Category category);

    List<Category> domainListToEntityList(List<io.tomato.catalog.domain.Category> categories);

    @InheritInverseConfiguration
    io.tomato.catalog.domain.Category entityToDomain(Category entity);

    @InheritInverseConfiguration
    List<io.tomato.catalog.domain.Category> entityListToDomainList(List<Category> entities);
}
