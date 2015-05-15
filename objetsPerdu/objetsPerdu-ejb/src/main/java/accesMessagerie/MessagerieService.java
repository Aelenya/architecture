package accesMessagerie;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import dom.Message;
import dom.SessionMessage;
import dom.Utilisateur;


@Stateless
public class MessagerieService {
	
	@PersistenceContext(unitName = "basePersistence")
	EntityManager em;

	public void ajouterMessageByIdSession(MessageDTO message) {
		Message nouveauMessage=new Message();
		nouveauMessage.setDate(new Timestamp(System.currentTimeMillis()));
		nouveauMessage.setSession(getSessionById(message.getIdSession()));
		nouveauMessage.setTexte(message.getTexte());
		
		em.persist(nouveauMessage);
	}

	public List<Message> getListMessagesByIdSession(long idSession) {
		Query query =em.createQuery("SELECT m FROM Message m WHERE  m.session.idSession=?1");
		query.setParameter("1", idSession);
		return query.getResultList();
	}

	public List<SessionMessage> getListeSessionMessageUtilisateur(Utilisateur util) {//le bug vient d'ici
		 /*CriteriaBuilder cb = em.getCriteriaBuilder();
		 
		 CriteriaQuery<SessionMessage> q = cb.createQuery(SessionMessage.class);
		 Root<SessionMessage> c = q.from(SessionMessage.class);
		 q.select(c).where(cb.equal(c.get("destinataire"), util));
		
		 Query query=em.createQuery(q);*/
		
		Query query =em.createQuery("SELECT s FROM SessionMessage s WHERE  s.destinataire=?2");// OR s.expediteur=?2");
		query.setParameter("2", util);
		return query.getResultList();
	}
	
	
	private SessionMessage getSessionById(long id){
		Query query =em.createQuery("SELECT s FROM SessionMessage s WHERE  s.idSession=?1");
		query.setParameter("1", id);
		return (SessionMessage) query.getResultList().get(0);
	}

}
