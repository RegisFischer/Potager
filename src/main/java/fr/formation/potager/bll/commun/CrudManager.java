package fr.formation.potager.bll.commun;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bll.BLLException;

public interface CrudManager<E, K, D extends CrudRepository<E, K>>  {

	public void ajouter(E t) throws BLLException;
	public void modifier(E t) throws BLLException;
	public void supprimer(E t) throws BLLException;
	public Optional<E> trouverId(K id);
	public List<E> trouvertous();

	
}
