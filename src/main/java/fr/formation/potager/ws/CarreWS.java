package fr.formation.potager.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.GestionManager;
import fr.formation.potager.bll.carre.CarreManager;
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Potager;

@RestController
@RequestMapping("carres")
public class CarreWS extends CrudWS<Carre, GestionManager<Carre>>{

	@Autowired
	private CarreManager manager;

	@Autowired
	private PotagerManager potagerManager;


	@PostMapping("/ajouter/{idPotager}")
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
