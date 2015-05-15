package dom;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "Annonces")
public abstract class Annonce implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@NotNull
	@Column
	private String nom;

	@Column
	private String tags;

	@Column
	private String adresse;
	
	@Column
	private Date dateCreation;

	@NotNull
	private boolean signale;
	
	
	
	public void setSignale(boolean signale){
		this.signale = signale;
	}
	public boolean getSignale(){
		return signale;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDateCreation(Date dateCreation){
		this.dateCreation = dateCreation;
	}
	public Date getDateCreation(){
		return dateCreation;
	}
	public String getAdresse(){
		return adresse;
	}
	public void setAdresse(String adresse){
		this.adresse = adresse;
	}
	public void setTags(String tags){
		this.tags = tags;
	}
	public String getTags(){
		return tags;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}