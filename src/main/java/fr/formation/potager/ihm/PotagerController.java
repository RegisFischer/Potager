package fr.formation.potager.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.carre.CarreManager;
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bo.Potager;

@Controller
public class PotagerController {
	
	@Autowired
	PotagerManager potagerManager;
	
	@Autowired
	CarreManager carreManager;
	
	@GetMapping("/potager/{id}")
	public String  afficherPotager(@PathVariable Integer id,Model model) {
		model.addAttribute("potager", potagerManager.trouverId(id).get());
		model.addAttribute("carres", carreManager.trouverParPotager(potagerManager.trouverId(id).get()));
		return "potager/afficher";
	}

	@GetMapping("/potager/ajouter")
	public String ajouterPotager(Model model,Potager potager) {
		return "potager/ajouter";
	}
	
	@PostMapping("/potager/ajouter")
	public String ajouterEntityPotager(Potager potager,BindingResult result,Model model) {
		
		try {
			potagerManager.ajouter(potager);
		} catch (BLLException e) {
			result.addError(new ObjectError("potager", e.getMessage()));
		}
		return "redirect:/accueil";
	}
	
	@GetMapping("/potager/modifier/{id}")
	public String modifierPotager(@PathVariable Integer id,Model model,Potager potager) {
		
		model.addAttribute("potager", potagerManager.trouverId(id).get());
		return "potager/modifier";
	}
	
	@PostMapping("/potager/modifier/{id}")
	public String modifierEntityPotager(@PathVariable Integer id,Potager potager,BindingResult result,Model model) {
		potager.setId(id);
		try {
			potagerManager.modifier(potager);
		} catch (BLLException e) {
			result.addError(new ObjectError("potager", e.getMessage()));
		}
		return "redirect:/accueil";
	}
	
	@GetMapping("potager/supprimer/{id}")
	public String supprimerEntityPotager(@PathVariable Integer id) {
		
		try {
			potagerManager.supprimer(potagerManager.trouverId(id).get());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/accueil";
	}
	
	
}
