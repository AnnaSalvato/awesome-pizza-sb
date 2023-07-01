package it.awesomepizza.entities;


import it.awesomepizza.entities.common.EntityId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PIZZA")
public class Pizza extends EntityId {

	@ElementCollection
	@CollectionTable(name = "PIZZA_INGREDIENTS", joinColumns = @JoinColumn(name = "PIZZA_ID"))
	@Column(name = "INGREDIENT", length = 50, nullable = false)
	@NotNull
	private List<String> ingredients = new ArrayList<>();


	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
}
