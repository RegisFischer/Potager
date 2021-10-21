package fr.formation.potager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Potager {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String localisation;
	private String nom;
	private Integer surface;
	private String ville;
	
	public Potager(String localisation, String nom, Integer surface, String ville) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.surface = surface;
		this.ville = ville;
	}
	
	
}
