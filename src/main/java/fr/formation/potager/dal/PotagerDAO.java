package fr.formation.potager.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.potager.bo.Potager;


public interface PotagerDAO extends CrudRepository<Potager, Integer> {

	@Query("SELECT SUM(c.surface) FROM Carre c WHERE c.potager = :potager")
	Integer findSommeSurfaceCarre(@Param("potager") Potager monPotager);

}
