package objetsperdu;
/*
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import ejb.accesTag.TagService;
import ejb.dom.*;

@RequestScoped
@ManagedBean(name = "ajoutAnnonceBean")
public class AjoutAnnonceBean implements Serializable{
	
	private static final long serialVersionUID = 2778846868230006644L;

	private Annonce annonce;
	
	private MapModel model;
	private String nom, tags;
	private double latitude, longitude;
	
	@EJB
	private AnnonceService annonceService;
	@EJB
	private TagService tagService;
	
	public AjoutAnnonceBean(){
		annonce = new Annonce();
	}
	
	@PostConstruct
	public void init(){
		model = new DefaultMapModel();
	}

	public void addMarker(){
		Marker marker = new Marker(new LatLng(latitude,longitude), nom);
		model.addOverlay(marker);
		annonce.setLatitude(latitude);
		annonce.setLongitude(longitude);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + 
		latitude + ", Lng:" + longitude));
	}
	
	public void ajout(){
		Timestamp dateInscription = new Timestamp(System.currentTimeMillis());
		annonce.setDateCreation(dateInscription);
		tags = annonce.getTags();
		
		StringTokenizer st = new StringTokenizer(tags,",");
		while(st.hasMoreElements()){
			tagService.ajouter(st.nextElement().toString());
		}
		
		annonceService.creer(annonce);
	}
	
	public void setTags(String tags){
		this.tags = tags;
	}
	public String getTags(){
		return tags;
	}
	public Annonce getAnnonce(){
		return annonce;
	}
	public MapModel getModel(){
		return model;
	}
	public void setModel(MapModel model){
		this.model = model;
	}
	public String getNom(){
		return nom;
	}
	public void setNom(String nom){
		this.nom = nom;
	}
	public double getLatitude(){
		return latitude;
	}
	public void setLatitude(double latitude){
		this.latitude = latitude;
	}
	public double getLongitude(){
		return longitude;
	}
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

}
*/