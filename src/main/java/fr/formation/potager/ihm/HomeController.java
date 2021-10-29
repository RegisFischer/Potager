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
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bo.Potager;

@Controller
public class HomeController {

	@Autowired
	private PotagerManager potagerManager;
	
	@Autowired
	private PlanteManager planteManager;
	
	@GetMapping("/accueil")
	public String accueil(Model model) {
		model.addAttribute("potagers", potagerManager.trouvertous());
		model.addAttribute("plantes", planteManager.trouvertous());
		return "accueil";
	}
	
}
