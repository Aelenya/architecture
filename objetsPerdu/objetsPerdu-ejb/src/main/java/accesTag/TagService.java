package accesTag;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "tagService")
public class TagService {
	
	@PersistenceContext(unitName="basePersistence")
	private EntityManager em;
	
	public void ajouter(String tag){
		int q = em.createNativeQuery("INSERT INTO TAG (VALUE, IMPORTANCE) VALUES (\""+tag+"\",1) ON DUPLICATE KEY UPDATE IMPORTANCE = IMPORTANCE + 1").executeUpdate();
	}
	
	public List<String> getListe(){
		Query q = em.createNativeQuery("SELECT VALUE FROM TAG ORDER BY IMPORTANCE DESC LIMIT 15");
		return q.getResultList();
	}
	
	//Fonction pour retourner une plus grande liste de valeurs pour l'auto-completion
	public List<String> getBigListe(){
		Query q = em.createNativeQuery("SELECT VALUE FROM TAG ORDER BY IMPORTANCE DESC LIMIT 150");
		return q.getResultList();
	}
	

}
