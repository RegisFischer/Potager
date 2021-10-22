package fr.formation.potager.bll.plantesCarre;

import fr.formation.potager.bll.CrudManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.PlanteCarre;

public interface PlanteCarreManager extends CrudManager<PlanteCarre>{

	/**
	 * ajouterPlante : permet d'ajouter une quantite nb de plantes dans un carre
	 * 
	 * @param unCarre : Carre dans lequel on souhaite mettre des plantes
	 * @param unePlante : plantes qu'on souhaite ajouter dans le carre
	 * @param nb : nombre de plantes qu'on souhaite ajoute dans le carre
	 * 
	 * @throws PlantationException : retourne une exception si la surface de plant est superieur a la surface du carre
	 */
	void ajouterPlante(Carre unCarre, Plante unePlante,Integer nb) throws PlantationException;

}
