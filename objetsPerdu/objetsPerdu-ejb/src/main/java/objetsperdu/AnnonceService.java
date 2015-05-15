package objetsperdu;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dom.Annonce;

@Stateless
public class AnnonceService {

	@PersistenceContext(unitName="basePersistence")
	private EntityManager em;
	
	//avec @POST,@GET,@DELETE,@PUT on peut effectuer le lien egalement /!\
	//C'est ici qu'il va falloir faire les liens avec jQuery, etc...
	
	public List recherche(String champ){
		Query q = em.createQuery("SELECT ID, TITRE FROM Annonce WHERE TITRE LIKE '%"+champ+"%';");
		return q.getResultList();
	}
	public List tagRecherche(String tag){
		Query q = em.createQuery("SELECT * FROM Annonce WHERE Annonce.TAGS LIKE '%"+tag+"%'");
		return q.getResultList();
	}
	public void creer(Annonce a){
		em.persist(a);
	}

	
	
	public List<Annonce> getListeAnnonces(){
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Annonce> c = qb.createQuery(Annonce.class);
		TypedQuery<Annonce> query = em.createQuery(c);
		return query.getResultList();
	}
	
	
	public Annonce getAnnonceById(long idAnnonce) {
		Query q = em.createQuery("SELECT a FROM Annonce a WHERE a.id=:id");
		q.setParameter("id", idAnnonce );
		if (q.getResultList().isEmpty()){
			return null;
		}
		else {
			return (Annonce) q.getResultList().get(0);
		}
	}
	
}