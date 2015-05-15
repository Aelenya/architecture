package objetsperdu;
/*
import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ejb.dom.Utilisateur;

@RequestScoped
@ManagedBean
public class InscriptionBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur;
	
	@EJB(name="utilisateurService")
	private UtilisateurService utilisateurService;
	
	public InscriptionBean(){
		utilisateur = new Utilisateur();
	}
	
	public void inscrire() throws ExceptionUser{
		if(!utilisateurService.rechercheEmail(utilisateur.getEmail()))
		{
			Timestamp dateInscription = new Timestamp(System.currentTimeMillis());
			utilisateurService.creer(utilisateur);
		}
	}
	
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}

}
*/