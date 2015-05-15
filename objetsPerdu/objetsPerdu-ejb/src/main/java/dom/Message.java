package dom;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;

	private String texte;
	private SessionMessage session;
	private Timestamp date;
	
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public SessionMessage getSession() {
		return session;
	}
	public void setSession(SessionMessage session) {
		this.session = session;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	

}
