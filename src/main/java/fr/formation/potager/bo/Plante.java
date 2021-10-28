package fr.formation.potager.bo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plante {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nom;
	
	@Enumerated(EnumType.ORDINAL)	
	private TypePlante type;
	
	private String variete;

	
	private Integer surface;

	public Plante(String nom, TypePlante type, String variete, Integer surface) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surface = surface;
	}
	
	
}
