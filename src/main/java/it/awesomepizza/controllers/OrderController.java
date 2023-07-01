package it.awesomepizza.controllers;

import it.awesomepizza.controllers.exceptions.BusinessException;
import it.awesomepizza.entities.Order;
import it.awesomepizza.services.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Resource(name = "orderService")
	private OrderService orderService;

	/**
	 * Create a new order
	 * @param order order data
	 * @return created order data
	 */
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}


	/**
	 * Get order by id
	 * @param id order id
	 * @return order data
	 */
	@GetMapping(value = "/{id}")
	public Order findById(@PathVariable Long id) {
		return orderService.findById(id);
	}

	/**
	 * Find all order in status NEW
	 * @return a list of order in status NEW
	 */
	@GetMapping(value = "/opened")
	public List<Order> findAllOpened() {
		return orderService.findAllOpened();
	}

	/**
	 * Get the order in progress (if exist)
	 * @return order with IN_PROGRESS status
	 * @throws BusinessException
	 */
	@GetMapping(value = "/inprogress")
	public Order getOrderInProgress() throws BusinessException {
		return orderService.getInProgress();
	}

	/**
	 * Change the status of the older order (if exits) from NEW to IN_PROGRESS
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping(value = "/older-in-progress")
	public Order setOlderOrderInProgress() throws BusinessException {
		return orderService.setOlderOrderInProgress();
	}

	/**
	 * Change the status of the order with id input parameter from NEW to IN_PROGRESS.
	 * @param id order id to change status from NEW to IN_PROGRESS
	 * @return updated order
	 * @throws BusinessException
	 */
	@PutMapping(value = "/{id}/in-progress")
	public Order setOrderInProgress(@PathVariable Long id) throws BusinessException {
		return orderService.setOrderInProgress(id);
	}

	/**
	 * Complete the IN_PROGRESS order
	 * @return updated order
	 * @throws BusinessException
	 */
	@PutMapping(value = "/complete-in-progress")
	public Order completeInProgressOrder() throws BusinessException {
		return orderService.completeInProgressOrder();
	}

}
