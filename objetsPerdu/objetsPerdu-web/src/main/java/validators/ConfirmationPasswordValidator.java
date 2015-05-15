package validators;
/*
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import objetsperdu.UtilisateurService;

@FacesValidator(value = "confirmationPasswordValidator")
public class ConfirmationPasswordValidator implements Validator{

	@EJB(name="utilisateurService")
	private UtilisateurService utilisateurService;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		UIInput composant= (UIInput) component.getAttributes().get("composantMotDePasse");
		String confirmation = (String)value;
		String password = (String)composant.getValue();
		if(!confirmation.equals(password))
		{
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le mot de passe et la confirmation sont differents",null));
		}
	}
}
*/