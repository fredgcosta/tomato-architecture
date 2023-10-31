package io.tomato.catalog.application.mappers;

import io.tomato.catalog.application.dtos.ProductDTO;
import io.tomato.catalog.infra.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface ProductMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "price", target = "price")
    io.tomato.catalog.domain.Product dtoToDomain(ProductDTO dto);

    List<io.tomato.catalog.domain.Product> dtoListToDomainList(List<ProductDTO> dtos);

    @InheritInverseConfiguration
    ProductDTO domainToDTO(io.tomato.catalog.domain.Product product);

    @InheritInverseConfiguration
    List<ProductDTO> domainListToDtoList(List<io.tomato.catalog.domain.Product> categories);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "price", target = "price")
    Product domainToEntity(io.tomato.catalog.domain.Product dto);

    List<Product> domainListToEntityList(List<io.tomato.catalog.domain.Product> categories);

    @InheritInverseConfiguration
    io.tomato.catalog.domain.Product entityToDomain(Product entity);

    @InheritInverseConfiguration
    List<io.tomato.catalog.domain.Product> entityListToDomainList(List<Product> entities);
}
