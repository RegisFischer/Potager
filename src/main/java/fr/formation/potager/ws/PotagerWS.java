package fr.formation.potager.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bo.Potager;

@RestController
public class PotagerWS {

	@Autowired
	private PotagerManager manager;
	
	@GetMapping("/potagers")
	public List<Potager> getAll(){
		return manager.trouvertous();
	}
	
	@GetMapping("/potager/{id}")
	public Potager getPotager(@PathVariable Integer id) {
		Optional<Potager> retour = manager.trouverId(id);
		if(retour.isEmpty()) {
			return retour.get();
		}else {
			return null;
		}
	}
	
	@PostMapping("/potager/ajouter")
	public List<Potager> add(@RequestBody Potager unPotager){
		try {
			manager.ajouter(unPotager);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}
	
	@PutMapping("/potager/modifer")
	public List<Potager> modify(@RequestBody Potager unPotager){
		try {
			manager.modifier(unPotager);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}
	
	@DeleteMapping("/potager/supprimer")
	public List<Potager> delete(@RequestBody Potager unPotager){
		try {
			manager.supprimer(unPotager);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return manager.trouvertous();
	}
}
