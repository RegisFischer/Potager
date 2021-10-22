package fr.formation.potager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.potager.PotagerException;
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
	
	public static void main(String[] args) {
		SpringApplication.run(PotagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testNominal();
		
	}

	private void testNominal() {
		Potager monPotager = new Potager("Ecole ENI", "monPotager", 200,"Quimper");
		
		Plante tomatier = new Plante("tomatier",TypePlante.FRUIT,"Marmande",2);
		Plante fraisier = new Plante("fraisier",TypePlante.FRUIT,"Plougastel",4);
		Carre unCarre = new Carre(16,TypeSol.ARGILE,typeExposition.SUD_EST);
		Carre unAutreCarre = new Carre(4,TypeSol.ARGILE,typeExposition.SUD_EST);
		try {
			potagerManager.ajouter(monPotager);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		
		potagerManager.ajouterUnePante(unCarre,tomatier,3);
		potagerManager.ajouterUnePante(unCarre,fraisier,2);
/*		
		try {
			potagerManager.ajouterUnCarre(monPotager, unCarre);
		} catch (PotagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			potagerManager.ajouterUnCarre(monPotager, unAutreCarre);
		} catch (PotagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			potagerManager.ajouterUnCarre(monPotager, unCarre);
		} catch (PotagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
	}

}
