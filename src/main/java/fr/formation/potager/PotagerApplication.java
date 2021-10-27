package fr.formation.potager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bll.Plante.PlanteManager;
import fr.formation.potager.bll.potager.PotagerException;
import fr.formation.potager.bll.potager.PotagerManager;
import fr.formation.potager.bll.relationPlantes.RelationManager;
import fr.formation.potager.bo.Carre;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.Potager;
import fr.formation.potager.bo.TypeExposition;
import fr.formation.potager.bo.TypePlante;
import fr.formation.potager.bo.TypeRelation;
import fr.formation.potager.bo.TypeSol;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner{
	
	@Autowired
	private PotagerManager potagerManager;
	
	@Autowired
	private RelationManager relationManager;
	
	@Autowired
	private PlanteManager planteManager;
	
	public static void main(String[] args) {
		SpringApplication.run(PotagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testNominal();
		
	}

	@Transactional
	private void testNominal() {
		Potager monPotager = new Potager("Ecole ENI", "monPotager", 200,"Quimper");
		Potager monAutrePotager = new Potager("The Best Potager", "monAutrePotager", 200,"Chateaulin");
		
		Plante tomatier = new Plante("tomatier",TypePlante.FRUIT,"Marmande",2);
		Plante fraisier = new Plante("fraisier",TypePlante.FRUIT,"Plougastel",4);
		Plante pommeterre = new Plante("Pomme de terre",TypePlante.RACINE,"Ploudaniel",5);
		
		Carre unCarre = new Carre(16,TypeSol.ARGILE,TypeExposition.SUD_EST);
		Carre unAutreCarre = new Carre(12,TypeSol.ARGILE,TypeExposition.SUD_EST);
		try {
			potagerManager.ajouter(monPotager);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		//relationManager.ajouterRelation(tomatier, fraisier, TypeRelation.AIME);
		relationManager.ajouterRelation(fraisier, pommeterre, TypeRelation.AIME);
		System.err.println(relationManager.getPlanterelation(fraisier, TypeRelation.AIME));
		potagerManager.ajouterUnePante(unCarre,tomatier,3);
		potagerManager.ajouterUnePante(unCarre,fraisier,2);
		potagerManager.ajouterUnePante(unAutreCarre, pommeterre, 1);
	
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
		
		System.out.println(potagerManager.trouvertous());
	}

}
