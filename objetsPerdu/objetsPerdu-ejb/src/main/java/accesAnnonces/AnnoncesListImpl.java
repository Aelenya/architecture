package accesAnnonces;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dom.Annonce;

@Stateless
public class AnnoncesListImpl implements AnnoncesList{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Annonce> getList(long latitude, long longitude) {
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Annonce> c = qb.createQuery(Annonce.class);
		TypedQuery<Annonce> query = entityManager.createQuery(c);	
		return query.getResultList();
	}

}
