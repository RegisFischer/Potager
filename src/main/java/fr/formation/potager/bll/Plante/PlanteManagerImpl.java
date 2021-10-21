package fr.formation.potager.bll.Plante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Plante;
import fr.formation.potager.dal.PlanteDAO;

@Service
public class PlanteManagerImpl implements PlanteManager {

	@Autowired
	private PlanteDAO dao;
	
	@Override
	public void ajouter(Plante unePlante) throws PlanteException {
		dao.save(unePlante);

	}

	@Override
	public void modifier(Plante unePlante) throws PlanteException {
		dao.save(unePlante);

	}

	@Override
	public void supprimer(Plante unePlante) throws PlanteException {
		dao.delete(unePlante);;

	}

	@Override
	public Optional<Plante> trouverId(int id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Plante> trouvertous() {
	
		return (List<Plante>) dao.findAll();
	}

}
