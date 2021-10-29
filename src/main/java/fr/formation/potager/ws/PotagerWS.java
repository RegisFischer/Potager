package fr.formation.potager.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.potager.bll.GestionManager;
import fr.formation.potager.bo.Potager;

@RestController
@RequestMapping("potagers")
public class PotagerWS extends CrudWS<Potager, GestionManager<Potager>>{

}
