package dom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "Utilisateurs")
public class Utilisateur implements Serializable{
	
	private static final long serialVersionUID = -7568648355548730251L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@NotNull(message = "Veuillez choisir un pseudo")
	@Size(min = 3, message = "Le pseudo doit etre compose d'au moins 3 caracteres")
	@Column(length = 32, nullable = false)
	private String pseudo;
	@NotNull(message = "Veuillez choisir une adresse mail")
	@Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message="Veuillez entrer une adresse mail valide")
	@Column(length = 32, nullable = false)
	private String email;
	@NotNull(message = "Veuillez choisir un mot de passe")
	
	//ATTENTION, NE DECOMMENTEZ PAS CES LIGNES POUR LE MOMENT SINON LA VALIDATION AVEC L'ENCRYPTION NE SE FERA PLUS !!!
	//@Pattern(regexp = ".*(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*", 
	//message="Votre mot de passe doit contenir au moins une majuscule, un chiffre et doit etre au moins de taille 8")
	
	@Column(length = 64, nullable = false)
	private String password;
	@Column(length= 32, nullable = false)
	private String groupe;
	
	//annotation @Transient rend une variable non persistente dans la DB

	public void setGroupe(String groupe){
		this.groupe = groupe;
	}
	public String getGroupe(){
		return groupe;
	}
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPseudo(){
		return pseudo;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return password;
	}
	public long getId(){
		return id;
	}

}
