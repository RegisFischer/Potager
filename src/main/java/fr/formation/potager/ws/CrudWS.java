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
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.GestionManager;

public abstract class CrudWS<E,M extends GestionManager<E>> {
	@Autowired
	M manager;
	
	@GetMapping("/tous")
	public List<E> getAll(){
		
		return manager.trouvertous();
	}
	
	@GetMapping("/{id}")
	public E getById(@PathVariable Integer id) {
		Optional<E> retour = manager.trouverId(id);
		
		if(!retour.isEmpty()) {
			return retour.get();
		}else {
			return null;
		}
	}
	
	@PostMapping("/ajouter")
	public List<E> add(@RequestBody E entity){

			try {
				manager.ajouter(entity);
			} catch (BLLException e) {
				e.printStackTrace();
			}

		return manager.trouvertous();
	}
	
	@PutMapping("/modifier")
	public List<E> modify(@RequestBody E entity){
		try {
			manager.modifier(entity);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}
	
	@DeleteMapping("/supprimer")
	public List<E> delete(@RequestBody E entity){
		try {
			manager.supprimer(entity);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return manager.trouvertous();
	}
	
}
