package fr.formation.potager.bll.commun;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import fr.formation.potager.bll.BLLException;

public class CrudManagerImpl<E,K,D extends CrudRepository<E, K>> implements CrudManager<E, K, D> {

	@Autowired
	private D dao;

	@Override
	public void ajouter(E t) throws BLLException {
		dao.save(t);
		
	}

	@Override
	public void modifier(E t) throws BLLException {
		dao.save(t);
		
	}

	@Override
	public void supprimer(E t) throws BLLException {
		dao.delete(t);
		
	}

	@Override
	public Optional<E> trouverId(K id) {
		return dao.findById(id);
	}

	@Override
	public List<E> trouvertous() {
		return (List<E>) dao.findAll();
	}



}
