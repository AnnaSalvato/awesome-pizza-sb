package it.awesomepizza.services;

import it.awesomepizza.controllers.exceptions.BusinessException;
import it.awesomepizza.entities.Order;

import java.util.List;

public interface IOrderService {

	Order createOrder(Order order);
	Order findById(Long id);
	Order getInProgress() throws BusinessException;
	List<Order> findAllOpened();
	Order setOlderOrderInProgress() throws BusinessException;
	Order setOrderInProgress(Long id) throws BusinessException;
	Order completeInProgressOrder() throws BusinessException;

}
