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
import fr.formation.potager.bll.Plante.PlanteManager;
import fr.formation.potager.bo.Plante;

@Controller
public class PlanteController {
	@Autowired
	private PlanteManager planteManager;


	@GetMapping("/plante/ajouter")
	public String ajouterPlante(Model model,Plante plante) {
		return "plante/ajouter";
	}
	
	@PostMapping("/plante/ajouter")
	public String ajouterEntityPlante(Plante plante,BindingResult result,Model model) {
		
		try {
			planteManager.ajouter(plante);
		} catch (BLLException e) {
			result.addError(new ObjectError("plante", e.getMessage()));
		}
		return "redirect:/accueil";
	}
	
	@GetMapping("/plante/modifier/{id}")
	public String modifierPlante(@PathVariable Integer id,Model model,Plante plante) {
		
		model.addAttribute("plante", planteManager.trouverId(id).get());
		return "plante/modifier";
	}
	
	@PostMapping("/plante/modifier/{id}")
	public String modifierEntityPotager(@PathVariable Integer id,Plante plante,BindingResult result,Model model) {
		plante.setId(id);
		try {
			planteManager.modifier(plante);
		} catch (BLLException e) {
			result.addError(new ObjectError("potager", e.getMessage()));
		}
		return "redirect:/accueil";
	}
	
	@GetMapping("plante/supprimer/{id}")
	public String supprimerEntityPotager(@PathVariable Integer id) {
		
		try {
			planteManager.supprimer(planteManager.trouverId(id).get());
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return "redirect:/accueil";
	}
}
