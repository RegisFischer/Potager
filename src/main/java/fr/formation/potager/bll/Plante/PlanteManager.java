package fr.formation.potager.bll.Plante;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import fr.formation.potager.bll.CrudManager;
import fr.formation.potager.bo.Plante;

public interface PlanteManager extends CrudManager<Plante> {

	Optional<Plante> trouverParNomEtVariete(String nom,String variete);

}
