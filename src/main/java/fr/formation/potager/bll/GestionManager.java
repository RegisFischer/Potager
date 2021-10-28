package fr.formation.potager.bll;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bll.commun.CrudManager;

public interface GestionManager<T> extends CrudManager<T, Integer, CrudRepository<T,Integer>>{

}
