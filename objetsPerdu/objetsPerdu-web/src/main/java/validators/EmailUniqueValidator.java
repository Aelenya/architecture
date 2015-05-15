package validators;
/*
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import objetsperdu.UtilisateurService;

@ManagedBean
@RequestScoped
public class EmailUniqueValidator implements Validator{
	
	@EJB(name="utilisateurService")
	private UtilisateurService utilisateurService;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		String email = (String)value;
		try{
			if( utilisateurService.rechercheEmail(email)){
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cette adresse mail existe deja",null));
			}
		}catch(Exception ex){
			//Prepare un message d'erreur au cas ou il y a une exception inatendue a affiche a l'utilisateur
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(component.getClientId(facesContext), message);
		}
		
	}
}
*/