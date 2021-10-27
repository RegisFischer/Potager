package fr.formation.potager.bll.carre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;
import fr.formation.potager.dal.CarreDAO;

@Service
public class CarreManagerImpl implements CarreManager {
	
	@Autowired
	private CarreDAO dao;
	

	@Override
	public void ajouter(Carre unCarre) throws CarreException {
		if(!trouvertous().contains(unCarre)) {
			dao.save(unCarre);
		}
	}

	@Override
	public void modifier(Carre unCarre) throws CarreException {
		dao.save(unCarre);

	}

	@Override
	public void supprimer(Carre unCarre) throws CarreException {
		dao.delete(unCarre);

	}

	@Override
	public Optional<Carre> trouverId(Integer id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Carre> trouvertous() {
		
		return (List<Carre>) dao.findAll();
	}

	@Override
	public List<Carre> trouverParPotager(Potager potager) {
		
		return dao.findByPotager(potager);
	}



}
