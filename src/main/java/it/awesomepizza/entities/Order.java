package it.awesomepizza.entities;

import it.awesomepizza.entities.common.EntityId;
import it.awesomepizza.entities.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDER_AW")
public class Order extends EntityId {

	@Column(name = "USERNAME", length = 50)
	@NotBlank
	private String username;

	@Column(name = "STATUS", length = 1)
	@NotNull
	private OrderStatus status;

	@Column(name = "ORDER_DATE", columnDefinition = "TIMESTAMP")
	@NotNull
	private LocalDateTime orderDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	@NotEmpty
	private List<Pizza> pizzas = new ArrayList<>();


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
}
