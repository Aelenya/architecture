package accesAnnonces;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class AnnonceDTO {
	
private String type;
	

	private long id;
	private String nom;
	private String tags;
	private String adresse;
	private Date dateCreation;
	private String texteAnnonce;
	
	
	
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getTexteAnnonce() {
		return texteAnnonce;
	}
	public void setTexteAnnonce(String texteAnnonce) {
		this.texteAnnonce = texteAnnonce;
	}
	
	
	
	
	
	
	
	
	
	
	

}
