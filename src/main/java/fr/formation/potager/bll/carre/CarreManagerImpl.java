package fr.formation.potager.bll.carre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bll.Plante.PlanteManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.dal.CarreDAO;

@Service
public class CarreManagerImpl implements CarreManager {
	
	@Autowired
	private CarreDAO dao;
	
	@Autowired
	private PlanteManager planteManager;

	@Override
	public void ajouter(Carre unCarre) throws CarreException {
		dao.save(unCarre);

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
	public Optional<Carre> trouverId(int id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Carre> trouvertous() {
		
		return (List<Carre>) dao.findAll();
	}



}
