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
import fr.formation.potager.bll.Plante.PlanteManager;
import fr.formation.potager.bo.Plante;

@RestController
public class PlanteWS {
	
	@Autowired
	PlanteManager manager;
	
	@GetMapping("/plantes")
	public List<Plante> getAll(){
		return manager.trouvertous();
	}
	
	@GetMapping("/plante/{id}")
	public Plante getById(@PathVariable Integer id) {
		Optional<Plante> retour = manager.trouverId(id);
		
		if(!retour.isEmpty()) {
			return retour.get();
		}else {
			return null;
		}
	}
	
	@PostMapping("plante/ajouter")
	public List<Plante> add(@RequestBody Plante unePlante){
		try {
			manager.ajouter(unePlante);
		} catch (BLLException e) {
			e.getMessage();
		}
		return manager.trouvertous();
	}
	
	@PutMapping("plante/modifier")
	public List<Plante> modify(@RequestBody Plante unePlante){
		try {
			manager.modifier(unePlante);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}
	
	@DeleteMapping("plante/supprimer")
	public List<Plante> delete(@RequestBody Plante unePlante){
		try {
			manager.supprimer(unePlante);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}
	
}
