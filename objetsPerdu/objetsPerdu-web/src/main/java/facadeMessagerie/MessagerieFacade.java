package facadeMessagerie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import dom.Annonce;
import dom.Message;
import dom.SessionMessage;
import dom.Utilisateur;
import accesMessagerie.MessageDTO;
import accesMessagerie.MessagerieService;
import accesMessagerie.SessionMessageDTO;
import accesUtilisateur.UtilisateurDTO;
import accesUtilisateur.UtilisateurService;
import objetsperdu.AnnonceService;
//import test.testDTO;

@Stateless
@LocalBean
@Path("facadeMessagerie")
public class MessagerieFacade {
	
	
	@EJB
	UtilisateurService utilisateurService;
	@EJB
	MessagerieService messagerieService;
	@EJB
	AnnonceService annonceService;
	
	
	@GET
	@Path("/getToutesLesSessionsDuUser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SessionMessageDTO> getToutesLesSessionsDuUser(@Context SecurityContext context){
	
		
		
		//convertir le string en utilisateur
		Utilisateur util=utilisateurService.getUtilisateurByEmail(context.getUserPrincipal().toString());
		
		
		//recevoir la liste des sessionMessages auxquelles il est lie
		List<SessionMessage> listeSessionMessage=messagerieService.getListeSessionMessageUtilisateur(util);
		List<SessionMessageDTO> listeSessionMessageDTO=new ArrayList<SessionMessageDTO>();
		//traduction en sessionMessageDTO
		for (int i=0; i<listeSessionMessage.size(); i++){
			SessionMessageDTO smDTO=new SessionMessageDTO();
			//retrouve le titre de l'annonce correspondate a l'idAnnonce
			//Annonce a=annonceService.getAnnonceById(listeSessionMessage.get(i).getReferenceAnnonce().getId());
			//smDTO.setAnnonce(a.get);
			
			smDTO.setDestinataire(listeSessionMessage.get(i).getDestinataire().getPseudo());
			smDTO.setExpediteur(listeSessionMessage.get(i).getExpediteur().getPseudo());
			smDTO.setIdSession(listeSessionMessage.get(i).getIdSession());
			listeSessionMessageDTO.add(smDTO);
		}
		return listeSessionMessageDTO;
		
		
	}
	
	/*@GET
	@Path("/User")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilisateurDTO> getListUtilisateurs(){
		/*
		 * Attention, cette fonction est utilisee dans le scripte Mesagerie/Messagerie.js ET Messagerie/creationSessionMessage.js
		 * 
		 * Cette fonction sert a pour but de remplir une listeMenu avec tous les utilisateurs afin d'en choisir un en particulier
		 
		List<Utilisateur>listeUtilisateurs=utilisateurService.getListUtilisateurs();
		List<UtilisateurDTO> listeDTO=new ArrayList<UtilisateurDTO>();
		UtilisateurDTO utilDTO;
		//traduit un Utilisateur en UtilisateurDTO
		
		for (int i=0; i<listeUtilisateurs.size(); i++){
			utilDTO=new UtilisateurDTO();
			
			//utilDTO.setEmail(listeUtilisateurs.get(i).getEmail());
			//utilDTO.setPassword(listeUtilisateurs.get(i).getPassword());
			
			utilDTO.setPseudo(listeUtilisateurs.get(i).getPseudo());
			
			listeDTO.add(utilDTO);
		}
		return listeDTO;
	}
	
	
	@GET
	@Path("{user}")//permet de recuperer un utilisateur => url.../pseudoUser
	@Produces(MediaType.APPLICATION_JSON)
	public List<SessionMessageDTO> getSessionMessageUtilisateur(@PathParam("user") String pseudo){
		//convertir le string en utilisateur
		Utilisateur util=utilisateurService.getUtilisateurByPseudo(pseudo);
		//recevoir la liste des sessionMessages auxquelles il est lie
		List<SessionMessage> listeSessionMessage=messagerieService.getListeSessionMessageUtilisateur(util);
		List<SessionMessageDTO> listeSessionMessageDTO=new ArrayList<SessionMessageDTO>();
		//traduction en sessionMessageDTO
		for (int i=0; i<listeSessionMessage.size(); i++){
			SessionMessageDTO smDTO=new SessionMessageDTO();
			//retrouve le titre de l'annonce correspondate a l'idAnnonce
			Annonce a=annonceService.getAnnonceById(listeSessionMessage.get(i).getReferenceAnnonce().getId());
			smDTO.setAnnonce(a.getTitre());
			smDTO.setDestinataire(listeSessionMessage.get(i).getDestinataire().getPseudo());
			smDTO.setExpediteur(listeSessionMessage.get(i).getExpediteur().getPseudo());
			smDTO.setIdSession(listeSessionMessage.get(i).getIdSession());
			listeSessionMessageDTO.add(smDTO);
		}
		return listeSessionMessageDTO;
	
	}*/
	
	
	@POST
	@Path("/getMessagesSession")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageDTO> getMessagesSession(SessionMessageDTO session){
		/*
		 * cette fonction renvoie la liste de tous les messages propre a une session de message
		 */
		List<Message> listeMessage=messagerieService.getListMessagesByIdSession(session.getIdSession());
		List<MessageDTO> listeMessageDTO=new ArrayList<MessageDTO>();
		for (int i=0; i<listeMessage.size(); i++){
			MessageDTO messageDTO=new MessageDTO();
			messageDTO.setDate(listeMessage.get(i).getDate());
			messageDTO.setTexte(listeMessage.get(i).getTexte());
			listeMessageDTO.add(messageDTO);
		}
		return listeMessageDTO;
	}
	
	@POST
	@Path("/ajoutMessageSession")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterMessageSessionCourante(MessageDTO message){
		/*
		 * Cette fonction ajout un message a une session particuliere a l'aide de l'id de cette session
		 */
		messagerieService.ajouterMessageByIdSession(message);
		
	}
	

}
