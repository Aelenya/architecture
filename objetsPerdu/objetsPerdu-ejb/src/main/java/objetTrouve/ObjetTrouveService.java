package objetTrouve;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dom.ObjetTrouve;

@Stateless
public class ObjetTrouveService {

	@PersistenceContext(unitName = "basePersistence")
	private EntityManager em;

	public void creer(ObjetTrouve objetTrouve) {
		em.persist(objetTrouve);
	}

}
