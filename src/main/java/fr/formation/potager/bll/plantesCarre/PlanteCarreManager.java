package fr.formation.potager.bll.plantesCarre;

import fr.formation.potager.bll.CrudManager;
import fr.formation.potager.bll.carre.CarreException;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.PlanteCarre;

public interface PlanteCarreManager extends CrudManager<PlanteCarre>{

	void ajouterPlante(Carre unCarre, Plante unePlante,Integer nb) throws PlantationException;

}
