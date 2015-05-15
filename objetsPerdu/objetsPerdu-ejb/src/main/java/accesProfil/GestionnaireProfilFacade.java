package accesProfil;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import accesUtilisateur.UtilisateurDTO;

@Stateless
@LocalBean
@Path("profil")
public class GestionnaireProfilFacade {

	@EJB
	GestionnaireProfilService gestionnaireProfilService;

	@PUT
	@Path("/profilModifPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePassword(UtilisateurDTO utilisateurDTO) throws Exception {

		gestionnaireProfilService.modifierMotDePasse(
				utilisateurDTO.getPassword(), utilisateurDTO.getPseudo());

	}

	@PUT
	@Path("/profilModifMail")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmail(UtilisateurDTO utilisateurDTO) throws Exception {

		gestionnaireProfilService.modifierAdresseMail(
				utilisateurDTO.getEmail(), utilisateurDTO.getPseudo());

	}

	//@DELETE
	@PUT
	@Path("/deleteProfil")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeUser(UtilisateurDTO utilisateurDTO) throws Exception {

		gestionnaireProfilService.supprimer(utilisateurDTO.getPseudo());

	}

}
