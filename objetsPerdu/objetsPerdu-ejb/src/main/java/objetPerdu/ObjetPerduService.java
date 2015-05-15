package objetPerdu;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dom.ObjetPerdu;

@Stateless(name="objetPerduService")
public class ObjetPerduService {

	@PersistenceContext(unitName = "basePersistence")
	private EntityManager em;
	
	public void creer(ObjetPerdu objetPerdu) {
		em.persist(objetPerdu);
	}
	
	public List<ObjetPerdu> getLastAnnonces(){
		Query q = em.createQuery("SELECT o FROM ObjetPerdu o ORDER BY o.dateCreation");
		return q.getResultList();
	}
	public ObjetPerdu getAnnonce(long id){
		Query q = em.createQuery("SELECT o FROM ObjetPerdu o WHERE o.id=?1");
		q.setParameter("1",id);
		ObjetPerdu obj = (ObjetPerdu)q.getResultList().get(0);
		return obj;
	}
	public void signale(long id){
		Query q = em.createQuery("UPDATE ObjetPerdu o SET signale='1' WHERE o.id=?1");
		q.setParameter("1",id);
		q.executeUpdate();
	}

}
