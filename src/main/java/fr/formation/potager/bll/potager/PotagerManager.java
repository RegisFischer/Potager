package fr.formation.potager.bll.potager;

import fr.formation.potager.bll.CrudManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;

public interface PotagerManager extends CrudManager<Potager> {
	
	/**
	 * ajouterUnCarre permet d'ajouter un carre a un potager
	 * 
	 * @param unPotager : Potager auquel on souhaite ajouter un carre
	 * 
	 * @param unCarre : Carre a ajouter au potager
	 * @throws  : renvoie une exception si la surface restante du potager ne peut pas accueillir le carre 
	 */
	public void ajouterUnCarre(Potager unPotager,Carre unCarre) throws PotagerException;
	
	public void ajouterUnePante(Carre unCarre,Plante unePlante, Integer nb);
}
