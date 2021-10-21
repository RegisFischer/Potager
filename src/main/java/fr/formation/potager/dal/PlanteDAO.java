package fr.formation.potager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.Plante;

public interface PlanteDAO extends CrudRepository<Plante, Integer> {

}
