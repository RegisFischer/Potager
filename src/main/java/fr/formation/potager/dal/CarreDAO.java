package fr.formation.potager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.Carre;

public interface CarreDAO extends CrudRepository<Carre, Integer> {

}
