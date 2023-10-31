package io.tomato.customer.application.mappers;

import io.tomato.customer.application.dtos.CustomerAddressDTO;
import io.tomato.customer.domain.CustomerAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jakarta")
public interface CustomerAddressMapper {
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "addressType", target = "addressType")
    @Mapping(source = "isPrincipal", target = "isPrincipal")
    CustomerAddress dtoToDomain(CustomerAddressDTO dto);
}
