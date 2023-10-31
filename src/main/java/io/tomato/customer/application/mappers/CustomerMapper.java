package io.tomato.customer.application.mappers;

import io.tomato.customer.application.dtos.CustomerDTO;
import io.tomato.customer.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jakarta")
public interface CustomerMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
        //    @Mapping(source = "shoppingCartItems", target = "shoppingCartItems")
        //    @Mapping(source = "customerAddress", target = "customerAddress")
        //    @Mapping(source = "orders", target = "orders")
    Customer dtoToDomain(CustomerDTO dto);
}
