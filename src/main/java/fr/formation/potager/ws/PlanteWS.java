package fr.formation.potager.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.potager.bll.GestionManager;
import fr.formation.potager.bo.Plante;

@RestController
@RequestMapping("plantes")
public class PlanteWS extends CrudWS<Plante, GestionManager<Plante>>{
	

}
