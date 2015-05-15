package accesMessagerie;

import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import dom.SessionMessage;


public class MessageDTO {
	
	//objet qui sert a contenir des donnees. Cet objet sera envoye en JSON
	//quand on fait {"texte": "nouveau message JSON"}
	//ca va cree une instance de cette classe contenant "nouveau message JSON"
	//Dans l'objet FACADE, 
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//public void createNewMessage(MessageDTO messageDTO){...}
	//et on accede avec les getters
	
	private String texte;
	//private String destinataire;
	//private String expediteur;
	private long idAnnonce;
	private Timestamp date;
	private long idSession;//ou session carement?

	
	

	
	public long getIdSession() {
		return idSession;
	}
	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp timestamp) {
		this.date = timestamp;
	}
	/*public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}*/
	public long getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	
	
	
}
