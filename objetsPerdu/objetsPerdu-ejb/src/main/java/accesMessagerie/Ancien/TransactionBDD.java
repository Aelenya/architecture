package accesMessagerie.Ancien;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dom.Annonce;
import dom.Message;
import dom.SessionMessage;
import dom.Utilisateur;

@Stateless
public class TransactionBDD {
	/*
	 * Effectue les transactions avec la base de donnee
	 */

	@PersistenceContext(unitName = "basePersistence")
	EntityManager em;

	public List<Annonce> getAnnonce() {
		/*
		 * renvoie une liste de toutes les annonces. Utilise pour prendre la premiere annonce=> pour les tests
		 */
		Query query = em.createQuery("SELECT a FROM Annonce a");
		return query.getResultList();
	}
	public List<Utilisateur> getUtilisateurs(){
		/*
		 * renvoie une liste de toutes les utilisateurs. Utilise pour prendre les 2 premiers utilisateurs(expediteur et destinataire)=> pour les tests
		 */
		Query query = em.createQuery("SELECT u FROM Utilisateur u");
		return query.getResultList();
	}
	public void AjouterSession(SessionMessage sm) {
		em.persist(sm);
	}
	public SessionMessage retourneSessionMessage(Utilisateur destinataire,
			Utilisateur expediteur, Annonce annonce) {
		/*
		 * Cette fonction retourne une reference sur une session de message si 
		 * une session existe deja entre les 2 utilisateurs et pour l'annonce choisie
		 * sinon, retourne null
		 * 
		 * Attention, si plusieurs session existe(ce ne devrait pas etre le cas), on selectionne la premiere
		 */
		Query query =em.createQuery("SELECT s FROM SessionMessage s WHERE s.referenceAnnonce=?1 AND s.destinataire=?2 AND s.expediteur=?3");//a completer
		query.setParameter("1", annonce);
		query.setParameter("2", destinataire);
		query.setParameter("3", expediteur);
		List<SessionMessage> liste=query.getResultList();
		if (liste.isEmpty()){
			return null;
		}
		else {
			return liste.get(0);
		}
	}
	public void AjouterMessage(Message message) {
		/*
		 * inserer un message en base de donnee
		 */
		em.persist(message);
		
	}
	public List<Message> retourneMessages(Utilisateur destinataire,
			Utilisateur expediteur, Annonce annonce) {
		/*
		 * Selectionne tous les messages entre les 2 memes utilisateurs sur la meme annonce affin d'afficher la session de messagerie
		 * cette fonction retourne donc une liste de messages
		 */
		Query query1 =em.createQuery("SELECT m FROM Message m INNER JOIN SessionMessage s ON s=m.session WHERE s.referenceAnnonce=?1 AND s.destinataire=?2 AND s.expediteur=?3 ORDER BY m.date") ;
		query1.setParameter("1", annonce);
		query1.setParameter("2", destinataire);
		query1.setParameter("3", expediteur);
		return query1.getResultList();
	}
	
	public Utilisateur traduitStringUtilisateur(String string){
		Query query=em.createQuery("SELECT u FROM Utilisateur u WHERE u.id="+string);
		List<Utilisateur> lu=query.getResultList();
		if (lu.isEmpty()){
			return null;
		}
		else{
			return lu.get(0);
		}
	}
	public List<Message> getMessages() {
		//retourne tous les messages en bdd
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Message> c = qb.createQuery(Message.class);
		TypedQuery<Message> query = em.createQuery(c);
		return query.getResultList();
	}
}
