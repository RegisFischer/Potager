package fr.formation.potager.bll.commun;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CrudManager<E, K, D extends CrudRepository<E, K>>  {
	void AjoutEntity(E entity);

	void supprimerEntity(E entity);

	void modifierEntity(E entity);

	List<E> trouvertoutEntity();

	Optional<E> trouverEntityParId(K id);

}
