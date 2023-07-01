package it.awesomepizza.entities.common;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class EntityId {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDENTITY")
	@SequenceGenerator(name="IDENTITY", sequenceName = "identity_seq", allocationSize=50)
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
