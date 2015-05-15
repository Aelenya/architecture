package objetTrouve;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import dom.Tag;

@JsonPropertyOrder({"tags"})
public class ObjetTrouveDTO {
	private String nom;
	
	@JsonProperty("tags")
	private ArrayList<Tag> tags = new ArrayList<Tag>();
	
	private String adresse;
	
	
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

}
