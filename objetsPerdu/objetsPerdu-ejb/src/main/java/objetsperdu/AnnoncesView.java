package objetsperdu;
/*
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ejb.dom.Annonce;

@RequestScoped
@ManagedBean
public class AnnoncesView {

	@PersistenceContext(unitName = "basePersistence")
	private EntityManager em;
	
	private List<Annonce> list;
	private final int MAX_ANNONCES = 10;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init(){
		Query q = em.createQuery("SELECT a FROM Annonce a ORDER BY a.dateCreation DESC");
		list = q.getResultList();
	}
	
	public List<Annonce> getList(){
		List<Annonce> retour = new ArrayList<Annonce>();
		for(int i = 0; i < MAX_ANNONCES; i++){
			if(i < list.size()){
				retour.add(list.get(i));
			}
		}
		return retour;
	}
}
*/