package fr.formation.potager.bll.commun;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class CrudManagerImpl<E,K,D extends CrudRepository<E, K>> implements CrudManager<E, K, D> {

	@Autowired
	private D dao;
	@Override
	public void AjoutEntity(E entity) {
		dao.save(entity);
		
	}

	@Override
	public void supprimerEntity(E entity) {
		dao.delete(entity);
		
	}

	@Override
	public void modifierEntity(E entity) {
		dao.save(entity);
		
	}

	@Override
	public List<E> trouvertoutEntity() {
		return (List<E>) dao.findAll();
	}

	@Override
	public Optional<E> trouverEntityParId(K id) {
		
		return dao.findById(id);
	}

}
