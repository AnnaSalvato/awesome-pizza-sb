package it.awesomepizza.services;

import it.awesomepizza.controllers.exceptions.BusinessException;
import it.awesomepizza.entities.Order;
import it.awesomepizza.entities.enums.OrderStatus;
import it.awesomepizza.repositories.IOrderRepository;
import it.awesomepizza.utils.OrderUtils;
import jakarta.annotation.Resource;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service("orderService")
public class OrderService implements IOrderService {

	@Resource(name = "orderRepository")
	private IOrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		order.setStatus(OrderStatus.NEW);
		order.setOrderDate(LocalDateTime.now());
		return orderRepository.save(order);
	}

	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).orElseThrow();
	}

	@Override
	public Order getInProgress() throws BusinessException {
		return OrderUtils.getOnlyOneFromList(orderRepository.findAllByStatusOrderByOrderDate(OrderStatus.IN_PROGRESS));
	}

	@Override
	public List<Order> findAllOpened() {
		return orderRepository.findAllByStatusOrderByOrderDate(OrderStatus.NEW);
	}

	@Override
	public Order setOlderOrderInProgress() throws BusinessException {
		// If already exists an order with status "IN PROGRESS" throw exception
		Order inprogressOrder = getInProgress();
		if (inprogressOrder != null) {
			throw new BusinessException("EXISTS_ORDER_IN_PROGRESS");
		}
		List<Order> openedOrders = findAllOpened();
		if (CollectionUtils.isEmpty(openedOrders)) {
			throw new BusinessException("NO_ORDER_TO_MANAGE");
		}

		Order nextOrder = openedOrders.get(0);
		nextOrder.setStatus(OrderStatus.IN_PROGRESS);
		return orderRepository.save(nextOrder);
	}

	@Override
	public Order setOrderInProgress(Long id) throws BusinessException {
		// If already exists an order with status "IN PROGRESS" throw exception
		Order inprogressOrder = getInProgress();
		if (inprogressOrder != null) {
			throw new BusinessException("EXISTS_ORDER_IN_PROGRESS");
		}
		Order order = findById(id);
		if (order == null || order.getStatus() != OrderStatus.NEW) {
			throw new BusinessException("NO_ORDER_TO_MANAGE");
		}

		order.setStatus(OrderStatus.IN_PROGRESS);
		return orderRepository.save(order);
	}

	@Override
	public Order completeInProgressOrder() throws BusinessException {
		// If not exists an order with status "IN PROGRESS" throw exception
		Order inprogressOrder = getInProgress();
		if (inprogressOrder == null) {
			throw new BusinessException("NO_ORDER_IN_PROGRESS");
		}
		inprogressOrder.setStatus(OrderStatus.COMPLETE);
		return orderRepository.save(inprogressOrder);
	}
}
