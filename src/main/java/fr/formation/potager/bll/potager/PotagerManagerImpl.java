package fr.formation.potager.bll.potager;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.carre.CarreManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;
import fr.formation.potager.dal.PotagerDAO;

@Service
public class PotagerManagerImpl implements PotagerManager {
	
	@Autowired
	private PotagerDAO dao;
	
	@Autowired CarreManager carreManager;
	
	@Override
	public void ajouter(Potager unPotager) throws PotagerException {
		dao.save(unPotager);
	}

	@Override
	public void modifier(Potager unPotager) throws PotagerException {
		dao.save(unPotager);

	}

	@Override
	public void supprimer(Potager unPotager) throws PotagerException {
		dao.delete(unPotager);

	}

	@Override
	public Optional<Potager> trouverId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Potager> trouvertous() {
		return (List<Potager>) dao.findAll();
	}

	@Transactional
	@Override
	public void ajouterUnCarre(Potager unPotager, Carre unCarre) throws PotagerException {
		Integer somme= dao.findSommeSurfaceCarre(unPotager);
		if(somme !=null) {
			if (somme + unCarre.getSurface() > unPotager.getSurface()) {
				throw new PotagerException("Erreur : la surface du carre est trop grande pour etre ajouté");
			}
		}
		unCarre.setPotager(unPotager);
		try {
			carreManager.ajouter(unCarre);
		} catch (BLLException e) {
			throw new PotagerException(e.getMessage());
		}
	}

}
