package it.awesomepizza.repositories;

import it.awesomepizza.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPizzaRepository extends JpaRepository<Pizza, Long> {

}
