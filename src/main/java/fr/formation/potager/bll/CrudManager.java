package fr.formation.potager.bll;

import java.util.List;
import java.util.Optional;

public interface CrudManager<T> {

	public void ajouter(T t) throws BLLException;
	public void modifier(T t) throws BLLException;
	public void supprimer(T t) throws BLLException;
	public Optional<T> trouverId(int id);
	public List<T> trouvertous();
	
}
