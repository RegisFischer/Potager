package fr.formation.potager.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.carre.CarreManager;
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;

@RestController
public class CarreWS {

	@Autowired
	private CarreManager manager;

	@Autowired
	private PotagerManager potagerManager;

	@GetMapping("/carres")
	public List<Carre> getAll() {
		return manager.trouvertous();
	}

	@GetMapping("/carre/{id}")
	public Carre getById(@PathVariable Integer id) {
		Optional<Carre> retour = manager.trouverId(id);
		if (!retour.isEmpty()) {
			return retour.get();
		} else {
			return null;
		}
	}

	@PostMapping("/carre/ajouter/{idPotager}")
	public List<Carre> add(@RequestBody Carre unCarre, @PathVariable Integer idPotager) {
		Optional<Potager> retourPotager = potagerManager.trouverId(idPotager);
		if (!retourPotager.isEmpty()) {

			unCarre.setPotager(retourPotager.get());
			try {
				manager.ajouter(unCarre);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		return manager.trouvertous();

	}

	@DeleteMapping("/Carre/supprimer")
	public List<Carre> supprimer(@RequestBody Carre unCarre) {
		try {
			manager.supprimer(unCarre);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}

	@GetMapping("/carres/{idPotager}")
	public List<Carre> getByPotager(@PathVariable Integer idPotager) {
		Optional<Potager> retourPotager = potagerManager.trouverId(idPotager);
		if (!retourPotager.isEmpty()) {
			return manager.trouverParPotager(retourPotager.get());
		}else {
			return null;
		}
	}
}
