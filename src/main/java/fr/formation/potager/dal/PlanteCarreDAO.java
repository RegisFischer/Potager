package fr.formation.potager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.PlanteCarre;

public interface PlanteCarreDAO extends CrudRepository<PlanteCarre, Integer> {

}
