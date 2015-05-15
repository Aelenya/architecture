package accesMessagerie;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dom.Annonce;
import dom.Message;
import dom.SessionMessage;
import dom.Utilisateur;
import accesUtilisateur.UtilisateurService;
import objetsperdu.AnnonceService;

@Stateless
public class CreationSessionMessageService {
	
	@PersistenceContext(unitName = "basePersistence")
	EntityManager em;
	@EJB 
	UtilisateurService utilisateurService;
	@EJB
	AnnonceService annonceService;
	
	
	public void ajouterMessage(PremierMessageDTO premierMessageDTO){
		//tester si une session existe deja entre ces utilisateurs sur cette annonce
		Message message=new Message();
		message.setDate(new Timestamp(System.currentTimeMillis()));
		message.setTexte(premierMessageDTO.getTexte());
		
		Utilisateur destinataire=utilisateurService.getUtilisateurByPseudo(premierMessageDTO.getDestinataire());
		Utilisateur expediteur=utilisateurService.getUtilisateurByPseudo(premierMessageDTO.getExpediteur());
		Annonce annonce=annonceService.getAnnonceById(premierMessageDTO.getIdAnnonce());
		
		SessionMessage sm=retourneSessionMessage(destinataire, expediteur, annonce);
		if (sm==null){//si aucune session existe entre dest et exp pour cette annonce=> creer nouvelle session
			sm=new SessionMessage();
			message.setSession(sm);
			sm.addMessage(message);
   
			sm.setDestinataire(destinataire);
			sm.setExpediteur(expediteur);
			sm.setReferenceAnnonce(annonce);
			//em.persist(message);
			em.persist(sm);
		} else {//si session existe deja=> on ajout seulement le message
			sm.addMessage(message);
			message.setSession(sm);
			
			em.persist(message);
		}
	}


	private SessionMessage retourneSessionMessage(Utilisateur destinataire,
			Utilisateur expediteur, Annonce annonce) {
		/*
		 * Cette fonction retourne une reference sur une session de message si 
		 * une session existe deja entre les 2 utilisateurs et pour l'annonce choisie
		 * sinon, retourne null
		 * 
		 * Attention, si plusieurs session existe(ce ne devrait pas etre le cas), on selectionne la premiere
		 */
		Query query =em.createQuery("SELECT s FROM SessionMessage s WHERE  s.referenceAnnonce=?1 AND s.destinataire=?2 AND s.expediteur=?3");
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


}
