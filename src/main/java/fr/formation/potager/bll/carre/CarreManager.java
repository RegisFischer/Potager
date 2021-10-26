package fr.formation.potager.bll.carre;

import java.util.List;

import fr.formation.potager.bll.CrudManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;

public interface CarreManager extends CrudManager<Carre> {

	/**
	 * trouvertParPotager : permet de recuperer tous les carres du potager passe en param
	 * 
	 * @param potager : potager ou l'on souhaite recupéré les carrés
	 * 
	 * @return List<Carre> : Liste des carre
	 */
	List<Carre> trouverParPotager(Potager potager);


}
