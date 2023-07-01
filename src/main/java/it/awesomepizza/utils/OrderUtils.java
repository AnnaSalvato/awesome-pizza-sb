package it.awesomepizza.utils;

import it.awesomepizza.controllers.exceptions.BusinessException;
import it.awesomepizza.entities.Order;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class OrderUtils {

	public static Order getOnlyOneFromList(List<Order> order) throws BusinessException {
		if (CollectionUtils.isEmpty(order)) {
			return null;
		}
		if (order.size() > 1) {
			throw new BusinessException("ERROR_FIND_MORE_ORDER_THAN_1");
		}
		return order.get(0);
	}

}
