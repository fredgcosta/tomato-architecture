package io.tomato.customer.infra.converters;

import io.tomato.customer.domain.enums.AddressType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final AddressType attribute) {
        return Objects.nonNull(attribute) ? attribute.id() : null;
    }

    @Override
    public AddressType convertToEntityAttribute(final Integer id) {

        if (id == null) {
            return null;
        }
        return Stream.of(AddressType.values())
                .filter(c -> c.id().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
