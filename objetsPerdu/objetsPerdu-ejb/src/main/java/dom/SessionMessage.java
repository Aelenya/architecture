package dom;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author beffaco
 *
 */
@Entity
public class SessionMessage {
	
	/*
	 * Objet correspondant a la table SessionMessage dans la base de donnee
	 * 
	 * idSession: cle Primaire
	 * idAnnonce: id de l annonce associee
	 * emailUtilisateur: cle primaire de l'utilisateur, l'id de l'autre utilisateur est deja comprise dans l'annonce
	 * pointeurMessage: id du premier message de la session
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSession;//cle primaire
	private Annonce referenceAnnonce;
	private Utilisateur destinataire;
	private Utilisateur expediteur;
	@OneToMany(cascade={CascadeType.ALL})//on met cascade, car quand cree session message, cree aussi message en meme temps
	private List<Message> Messages = new ArrayList<Message>();
	
	
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public Annonce getReferenceAnnonce() {
		return referenceAnnonce;
	}
	public void setReferenceAnnonce(Annonce referenceAnnonce) {
		this.referenceAnnonce = referenceAnnonce;
	}
	public Utilisateur getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}
	public Utilisateur getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}
	public List<Message> getMessage() {
		return Messages;
	}
	public void addMessage(Message message) {
		Messages.add(message);
	}
	
	
	
	
	
	
	
	
	
	
	
}
