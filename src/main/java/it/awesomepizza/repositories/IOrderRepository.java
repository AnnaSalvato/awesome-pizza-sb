package it.awesomepizza.repositories;

import it.awesomepizza.entities.Order;
import it.awesomepizza.entities.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderRepository")
public interface IOrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByStatusOrderByOrderDate(OrderStatus status);


}
