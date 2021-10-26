package fr.formation.potager.bo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Carre {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="potager_id")
	private Potager potager;
	
	private Integer surface;
	
	@Enumerated(EnumType.ORDINAL)	
	private TypeSol typeSol;
	
	@Enumerated(EnumType.ORDINAL)	
	private TypeExposition typeExposition;

	public Carre(Integer surface, TypeSol typeSol,TypeExposition typeExposition) {
		super();
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExposition = typeExposition;
	}
	
	
}
