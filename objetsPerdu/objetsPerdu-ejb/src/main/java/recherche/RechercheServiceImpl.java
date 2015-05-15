package recherche;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import dom.ObjetPerdu;


@Stateless
public class RechercheServiceImpl implements RechercheService{
	
	@PersistenceContext
	private EntityManager em;
	
	private Root<ObjetPerdu> root;
	private CriteriaBuilder criteriaBuilder;
	CriteriaQuery<ObjetPerdu> query;
	private String separateurDef = "[\\s,;.:/%]";

	
	public void init(){
		criteriaBuilder = em.getCriteriaBuilder();
		query=criteriaBuilder.createQuery(ObjetPerdu.class);
		root = query.from(ObjetPerdu.class);
	}
	
	public List<ObjetPerdu> rechercheObjetPerdu(String mc, Date date, String lieu){
		init();
		Predicate p = criteriaBuilder.or(rechercheParTitre(mc),
				rechercheParTags(mc));
		p = criteriaBuilder.and(p, rechercheParLieu(lieu), rechercheParDate(date));
		CriteriaQuery<ObjetPerdu> resQuery = query.where(p);
		TypedQuery<ObjetPerdu> finalQuery = em.createQuery(resQuery);
		return finalQuery.getResultList();
	}
	
	public List<ObjetPerdu> rechercheObjetPerdu(RechercheDTO recherche){
		return rechercheObjetPerdu(recherche.getMotCle(), recherche.getDate(), recherche.getLieu());
	}
	
	private Predicate rechercheParDate(Date date){
		Expression<Date> dField = root.get("dateCreation").as(Date.class);
		Predicate p = criteriaBuilder.equal(dField, date);
		return p;
	}
	
	private Predicate rechercheParLieu(String lieu){
		return generiqueRecherche(lieu, root.get("adresse").as(String.class), separateurDef);
	}
	
	private Predicate rechercheParTitre(String titre){
		return generiqueRecherche(titre, root.get("nom").as(String.class), separateurDef);
	}
	
	private Predicate rechercheParTags(String tags){
		return generiqueRecherche(tags, root.get("tags").as(String.class), separateurDef);
	}
	
	private Predicate generiqueRecherche(String input, Expression<String> expr, String delimiter){
		String[] motCle = input.split(delimiter);
		Predicate p = criteriaBuilder.like(expr, transMotCle(motCle[0]));
		
		for(int i = 1 ; i < motCle.length ; i++){
			p = criteriaBuilder.or(p, criteriaBuilder.like(expr, transMotCle(motCle[i])));
		}
		return p;
	}
	
	private String transMotCle(String motCle){
		return "%".concat(motCle).concat("%");
	}
}
