package fr.formation.potager.bll.potager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bo.Potager;
import fr.formation.potager.dal.PotagerDAO;

@Service
public class PotagerManagerImpl implements PotagerManager {
	
	@Autowired
	private PotagerDAO dao;
	
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

}
