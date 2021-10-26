package fr.formation.potager.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;

public interface CarreDAO extends CrudRepository<Carre, Integer> {

	/**
	 * Recherche en Base la liste des carres ayant pour id_potager l'id du potager passe en param
	 * 
	 * @param potager : potager qui contient les carre
	 * 
	 * @return List<Carre>
	 */
	List<Carre> findByPotager(Potager potager);

}
