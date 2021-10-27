package fr.formation.potager.bll.relationPlantes;

import java.util.List;

import javax.transaction.Transactional;

import fr.formation.potager.bll.GestionManager;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.RelationPlante;
import fr.formation.potager.bo.TypeRelation;

public interface RelationManager extends GestionManager<RelationPlante>{

	@Transactional
	public void ajouterRelation(Plante plante1, Plante plante2,TypeRelation relation);
	
	public List<Plante> getPlanterelation(Plante unePlante,TypeRelation relation);
	
}
