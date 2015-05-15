package accesMessagerie.Ancien;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dom.Annonce;
import dom.Message;
import dom.SessionMessage;
import dom.Utilisateur;
@RequestScoped
@ManagedBean
public class BeanTestMessagerie {
	/*
	 * Recuperer 2 utilisateurs et une annonce
	 * 
	 * creer une session de message entre ces deux utilisateurs et cette annonce
	 * creer un message associe a cette sessin de message
	 * 
	 * efectue tous les intermediaires entre la vue (TestSessionMessage.xhtml)
	 * et le truc qui valide les donnees en bdd (TransactionBDD)
	 */
	
	
	@EJB
	TransactionBDD transactionbdd;
	
	//private List<Utilisateur> listeUtil;
	private Annonce annonce;
	private String texte;
	private String dest;
	private String exp;
	
	
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public List<Utilisateur> getListeUtilisateurs(){
		return transactionbdd.getUtilisateurs();
	}
	public Annonce getAnnonce(){
		if (annonce==null){
			annonce=transactionbdd.getAnnonce().get(0);
		}
		return annonce;
	}
	public String getTexte(){
		return texte;
	}
	public void setTexte(String texte){
		this.texte=texte;
	}
	
	public void valider(){
		//tester si une session existe deja entre ces utilisateurs sur cette annonce
		Message message=new Message();
		message.setDate(new Timestamp(System.currentTimeMillis()));
		message.setTexte(texte);
		
		Utilisateur destinataire=transactionbdd.traduitStringUtilisateur(dest);
		Utilisateur expediteur=transactionbdd.traduitStringUtilisateur(exp);
		//Annonce annonce=getAnnonce();
		
		SessionMessage sm=transactionbdd.retourneSessionMessage(destinataire, expediteur, getAnnonce());
		if (sm==null){//si aucune session existe entre dest et exp pour cette annonce=> creer nouvelle session
			sm=new SessionMessage();
			sm.addMessage(message);
			message.setSession(sm);
			
			
			sm.setDestinataire(destinataire);
			sm.setExpediteur(expediteur);
			sm.setReferenceAnnonce(getAnnonce());
		
			transactionbdd.AjouterSession(sm);
		} else {//si session existe deja=> on ajout seulement le message
			sm.addMessage(message);
			message.setSession(sm);
			
			transactionbdd.AjouterMessage(message);
		}
	}
	
	public List<Message> getMessages(){
		Utilisateur destinataire=transactionbdd.traduitStringUtilisateur(dest);
		Utilisateur expediteur=transactionbdd.traduitStringUtilisateur(exp);
		return transactionbdd.retourneMessages(destinataire, expediteur, annonce);
	}

}
