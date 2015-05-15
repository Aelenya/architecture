package accesMessagerie.Ancien;

import java.sql.Timestamp;
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

import dom.Message;
import accesMessagerie.MessageDTO;


@Stateless
@LocalBean
@Path("messagerie")
public class MessagerieFacade {
	@EJB
	TransactionBDD transactionbdd;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createNewMessage(MessageDTO messageDTO){
		
		Message message=new Message();
		message.setDate(new Timestamp(System.currentTimeMillis()));
		message.setTexte(messageDTO.getTexte());
	
		transactionbdd.AjouterMessage(message);//on fait persister le message en base de donnee
		
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageDTO> getMessages(){
		List<Message>listeMessages=transactionbdd.getMessages();
		List<MessageDTO> listeDTO=new ArrayList<MessageDTO>();
		
		//a ameliorer...
		for (int i=0; i<listeMessages.size(); i++){
			MessageDTO mDTO=new MessageDTO();
			mDTO.setTexte(listeMessages.get(i).getTexte());
			mDTO.setDate(listeMessages.get(i).getDate());
			listeDTO.add(mDTO);
			
		}
		
		return listeDTO;
	}

}
