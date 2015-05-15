package objetPerdu;

import java.sql.Date;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import dom.Tag;

@JsonPropertyOrder({"tags"})
public class ObjetPerduDTO {
	private long id;
	private String nom;
	private String texteAnnonce;
	private Date dateCreation;
	
	@JsonProperty("tags")
	private ArrayList<Tag> tags = new ArrayList<Tag>();
	private String adresse;
	
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getAdresse(){
		return adresse;
	}
	public void setAdresse(String adresse){
		this.adresse = adresse;
	}
	
	@JsonProperty("tags")
	public ArrayList<Tag> getTags(){
		return tags;
	}
	
	@JsonProperty("tags")
	public void setTags(ArrayList<Tag> tags){
		this.tags = tags;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTexteAnnonce() {
		return texteAnnonce;
	}
	public void setTexteAnnonce(String texteAnnonce) {
		this.texteAnnonce = texteAnnonce;
	}
	

}
