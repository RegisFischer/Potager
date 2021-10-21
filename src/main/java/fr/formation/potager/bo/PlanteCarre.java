package fr.formation.potager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PlanteCarre {

	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate dateInsert;
	private LocalDate dateRecolte;
	private Integer quantite;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="carre_id")
	private Carre unCarre;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="plante_id")
	private Plante unePlante;
	
	
}
