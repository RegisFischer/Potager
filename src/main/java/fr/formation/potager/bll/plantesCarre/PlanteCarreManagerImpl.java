package fr.formation.potager.bll.plantesCarre;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.Plante.PlanteManager;
import fr.formation.potager.bll.carre.CarreException;
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
		
		return (List<PlanteCarre>) dao.findAll();
	}

	@Transactional
	@Override
	public void ajouterPlante(Carre unCarre, Plante unePlante, Integer nb) throws PlantationException {
		PlanteCarre plantation = new PlanteCarre();

		try {
			planteManager.ajouter(unePlante);
			plantation.setUnePlante(unePlante);
		} catch (BLLException e1) {
			throw new PlantationException(e1.getMessage());
		}

		try {
			carreManager.ajouter(unCarre);
			plantation.setUnCarre(unCarre);
		} catch (BLLException e) {
			throw new PlantationException(e.getMessage());
		}
	
		plantation.setQuantite(nb);
		plantation.setDateInsert(LocalDate.now());
		plantation.setDateRecolte(plantation.getDateInsert().plusMonths(2));

		try {
			verifierSurface(plantation);
		} catch (CarreException e) {
			System.err.println(e.getMessage());
			throw new PlantationException(e.getMessage());
		}
		ajouter(plantation);

	}

	/**
	 * verifierSurface : permet de verifier si l'ajout de plante est possible en verifiant la surface diponible
	 * 
	 * @param plantation : plantation a verifier
	 * 
	 * @throws CarreException : retourne une exception si la surface disponible ne correspond pas
	 */
	private void verifierSurface(PlanteCarre plantation) throws CarreException {
		Integer somme = plantation.getUnePlante().getSurface() * plantation.getQuantite();

		Integer surfaceOccupe = dao.sommeSurfaceOccupé(plantation.getUnCarre());

		Integer total;
		if (surfaceOccupe == null) {
			System.out.println("total surface plante : " + somme);
			total = somme;
		} else {
			total = somme + surfaceOccupe;
			System.out.println("total surface occupe + les plantes : " + total);
		}
		if (total > plantation.getUnCarre().getSurface()) {
			System.out.println("surface du carre : " + plantation.getUnCarre().getSurface());
			throw new CarreException("Erreur : le carre ne peut supporte autant de plantes");
		}

	}

	@Override
	public void supprimerPlante(Carre unCarre, Plante unePlante, Integer nb) throws PlantationException {
		
		
	}

}
