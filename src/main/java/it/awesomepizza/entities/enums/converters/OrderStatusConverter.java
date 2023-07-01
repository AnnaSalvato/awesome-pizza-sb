package it.awesomepizza.entities.enums.converters;

import it.awesomepizza.entities.enums.OrderStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

	@Override
	public String convertToDatabaseColumn(OrderStatus status) {
		if (status == null) {
			return null;
		}
		return status.getStatus();
	}

	@Override
	public OrderStatus convertToEntityAttribute(String status) {
		if (status == null) {
			return null;
		}

		return Stream.of(OrderStatus.values())
				.filter(c -> c.getStatus().equals(status))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
