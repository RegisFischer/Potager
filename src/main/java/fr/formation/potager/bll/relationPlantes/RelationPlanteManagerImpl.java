package fr.formation.potager.bll.relationPlantes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.potager.bll.BLLException;
import fr.formation.potager.bo.Plante;
import fr.formation.potager.bo.RelationPlante;
import fr.formation.potager.bo.TypeRelation;
import fr.formation.potager.dal.RelationPlanteDAO;

@Service
public class RelationPlanteManagerImpl implements RelationManager {
	
	@Autowired
	private RelationPlanteDAO dao;

	@Override
	public void ajouter(RelationPlante t) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(RelationPlante t) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(RelationPlante t) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<RelationPlante> trouverId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RelationPlante> trouvertous() {
		return (List<RelationPlante>) dao.findAll();
	}

	@Override
	public void ajouterRelation(Plante plante1, Plante plante2, TypeRelation relation) {
	 dao.save(new RelationPlante(plante1,plante2,relation));
		
	}

	@Override
	public List<Plante> getPlanterelation(Plante unePlante, TypeRelation relation) {

	List<Plante> lst = dao.findAllRelation(unePlante,relation);
	for (Plante plante : dao.findAllRelationInv(unePlante, relation)) {
		lst.add(plante);
	}
	return lst;
	}


	
}
