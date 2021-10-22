package fr.formation.potager.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.Plante;

public interface PlanteDAO extends CrudRepository<Plante, Integer> {

	@Query
	Optional<Plante> findByNomAndVariete(String nom, String variete);

}
