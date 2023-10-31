package io.tomato.order.infra.converters;

import io.tomato.order.domain.enums.OrderStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final OrderStatus attribute) {
        return Objects.nonNull(attribute) ? attribute.id() : null;
    }

    @Override
    public OrderStatus convertToEntityAttribute(final Integer id) {

        if (id == null) {
            return null;
        }
        return Stream.of(OrderStatus.values())
                .filter(c -> c.id().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
