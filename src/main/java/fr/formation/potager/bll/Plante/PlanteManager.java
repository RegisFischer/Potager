package fr.formation.potager.bll.Plante;

import java.util.Optional;

import fr.formation.potager.bll.GestionManager;
import fr.formation.potager.bo.Plante;

public interface PlanteManager extends GestionManager<Plante> {

	/**
	 * TrouverParNomEtVariete : permet de r?cup?rer la plante avec le nom et la variete mis en parametre
	 * 
	 * @param nom : nom de la plante
	 * @param variete : variete de la plante
	 * 
	 * @return Optional : retourne une liste avec la possible presence d'une plante
	 */
	Optional<Plante> trouverParNomEtVariete(String nom,String variete);

}
