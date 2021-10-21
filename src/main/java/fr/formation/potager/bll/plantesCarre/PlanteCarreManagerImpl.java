package fr.formation.potager.bll.plantesCarre;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.Plante.PlanteManager;
import fr.formation.potager.bll.carre.CarreManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.PlanteCarre;
import fr.formation.potager.dal.PlanteCarreDAO;

@Service
public class PlanteCarreManagerImpl implements PlanteCarreManager {

	@Autowired
	private PlanteManager planteManager;

	@Autowired
	private CarreManager carreManager;
	
	@Autowired
	private PlanteCarreDAO dao;

	@Override
	public void ajouter(PlanteCarre plantation) throws PlantationException {
		dao.save(plantation);

	}

	@Override
	public void modifier(PlanteCarre t) throws BLLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(PlanteCarre t) throws BLLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<PlanteCarre> trouverId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanteCarre> trouvertous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterPlante(Carre unCarre, Plante unePlante, Integer nb) throws PlantationException {
		PlanteCarre plantation = new PlanteCarre();

		if (!planteManager.trouvertous().contains(unePlante)) {
			try {
				planteManager.ajouter(unePlante);
			} catch (BLLException e) {
				throw new PlantationException(e.getMessage());
			}
		}
		if (!carreManager.trouvertous().contains(unCarre)) {
			try {
				carreManager.ajouter(unCarre);
			} catch (BLLException e) {
				throw new PlantationException(e.getMessage());
			}
		}

		plantation.setUnePlante(unePlante);
		plantation.setUnCarre(unCarre);
		plantation.setQuantite(nb);
		plantation.setDateInsert(LocalDate.now());
		plantation.setDateRecolte(plantation.getDateInsert().plusMonths(2));

		ajouter(plantation);

	}

}
