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
		if (!trouverParNomEtVariete(unePlante.getNom(),unePlante.getVariete()).isEmpty()) {
			throw new PlanteException("Erreur : cette plante existe deja dans la base!");
		}else {		
				dao.save(unePlante);
		}

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

	@Override
	public Optional<Plante> trouverParNomEtVariete(String nom, String variete) {
		return dao.findByNomAndVariete(nom,variete);
	
	}

}
