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

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}


	@GetMapping(value = "/{id}")
	public Order findById(@PathVariable Long id) {
		return orderService.findById(id);
	}

	@GetMapping(value = "/opened")
	public List<Order> findAllOpened() {
		return orderService.findAllOpened();
	}

	@GetMapping(value = "/inprogress")
	public Order getOrderInProgress() throws BusinessException {
		return orderService.getInProgress();
	}

	@PutMapping(value = "/older-in-progress")
	public Order setOlderOrderInProgress() throws BusinessException {
		return orderService.setOlderOrderInProgress();
	}

	@PutMapping(value = "/{id}/in-progress")
	public Order setOrderInProgress(@PathVariable Long id) throws BusinessException {
		return orderService.setOrderInProgress(id);
	}

	@PutMapping(value = "/complete-in-progress")
	public Order completeInProgressOrder() throws BusinessException {
		return orderService.completeInProgressOrder();
	}

}
