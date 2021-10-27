package fr.formation.potager.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class RelationPlante {

	@Id
	@GeneratedValue
	private Integer id;

	@Enumerated(EnumType.ORDINAL)
	private TypeRelation relation;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="plante1_id")
	private Plante plante;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="plante2_id")
	private Plante unePlante;

	public RelationPlante(Plante unePlante, Plante plante, TypeRelation relation) {
		super();
		this.relation = relation;
		this.plante = plante;
		this.unePlante = unePlante;
	}
	
	
}
