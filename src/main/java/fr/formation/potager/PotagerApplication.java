package fr.formation.potager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.plantesCarre.PlantationException;
import fr.formation.potager.bll.plantesCarre.PlanteCarreManager;
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;
import fr.formation.potager.bo.TypePlante;
import fr.formation.potager.bo.TypeSol;
import fr.formation.potager.bo.typeExposition;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner{
	
	@Autowired
	private PotagerManager potagerManager;
	
	@Autowired
	private PlanteCarreManager carreManager;

	public static void main(String[] args) {
		SpringApplication.run(PotagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testNominal();
		
	}

	private void testNominal() {
		Potager monPotager = new Potager("Ecole ENI", "monPotager", 20,"Quimper");
		
		Plante unePlante = new Plante("tomatier",TypePlante.FRUIT,"Marmande",12);
		Carre unCarre = new Carre(monPotager,4,TypeSol.ARGILE,typeExposition.SUD_EST);
		try {
			potagerManager.ajouter(monPotager);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		unCarre.setPotager(monPotager);
		
		try {
			carreManager.ajouterPlante(unCarre,unePlante,3);
		} catch (PlantationException e) {
			e.getMessage();
		}
		
	}

}
