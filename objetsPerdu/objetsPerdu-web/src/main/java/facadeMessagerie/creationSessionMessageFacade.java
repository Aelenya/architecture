package facadeMessagerie;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dom.Annonce;
import accesAnnonces.AnnonceDTO;
import accesMessagerie.CreationSessionMessageService;
import accesMessagerie.MessageDTO;
import accesMessagerie.PremierMessageDTO;
import accesUtilisateur.UtilisateurService;
import objetsperdu.AnnonceService;



@Stateless
@LocalBean
@Path("facadeCreationSessionMessage")
public class creationSessionMessageFacade {
	
	@EJB
	UtilisateurService utilisateurService;
	@EJB
	CreationSessionMessageService creationSessionMessageService;
	@EJB
	AnnonceService annonceService;
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void AjouterMessage(PremierMessageDTO premierMessageDTO){
		creationSessionMessageService.ajouterMessage(premierMessageDTO);	
	}
	
	
	@GET
	@Path("/Annonce")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AnnonceDTO> getListAnnonces(){
		/*
		 * Cette fonction a pour but de renvoyer une liste de toutes les annonces au format DTO
		 * elle est utilisee dans la page Messagerie/creationSessionMessage.html pour 
		 * remplir le meni deroulant avec toutes les annonces afin de pouvoir creer une session de messagerie pour une annonce en particulier
		 */
		List<Annonce>listeAnnonces=annonceService.getListeAnnonces();
		List<AnnonceDTO> listeDTO=new ArrayList<AnnonceDTO>();
		//traduit les Annonce en AnnonceDTO
		for (int i=0; i<listeAnnonces.size(); i++){
			AnnonceDTO annonceDTO=new AnnonceDTO();
			annonceDTO.setAdresse(listeAnnonces.get(i).getAdresse());
			annonceDTO.setDateCreation(listeAnnonces.get(i).getDateCreation());
			//annonceDTO.setId(listeAnnonces.get(i).getId());
			annonceDTO.setNom(listeAnnonces.get(i).getNom());
			annonceDTO.setTags(listeAnnonces.get(i).getTags());
			//annonceDTO.setTexteAnnonce(texteAnnonce);
			//annonceDTO.setType(type);
			listeDTO.add(annonceDTO);
		}
		return listeDTO;
	}
	
}

