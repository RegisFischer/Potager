package fr.formation.potager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.RelationPlante;
import fr.formation.potager.bo.TypeRelation;

public interface RelationPlanteDAO extends CrudRepository<RelationPlante, Integer> {
	
	@Query("SELECT plante FROM  RelationPlante c WHERE c.unePlante = :plante AND c.relation = :relation ")
	List<Plante> findAllRelation(@Param("plante") Plante unePlante,@Param("relation") TypeRelation relation);

	@Query("SELECT unePlante FROM  RelationPlante c WHERE c.plante = :plante AND c.relation = :relation")
	List<Plante> findAllRelationInv(@Param("plante") Plante unePlante,@Param("relation") TypeRelation relation);
	
}
