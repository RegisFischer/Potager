package fr.formation.potager.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.PlanteCarre;

public interface PlanteCarreDAO extends CrudRepository<PlanteCarre, Integer> {

	@Query("SELECT SUM(p.quantite * p.unePlante.surface) FROM PlanteCarre p WHERE p.unCarre= :unCarre")
	Integer sommeSurfaceOccupé(@Param("unCarre") Carre unCarre);

}
