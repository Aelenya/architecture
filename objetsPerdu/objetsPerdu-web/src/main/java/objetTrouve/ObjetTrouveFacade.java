package objetTrouve;

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

import objetTrouve.ObjetTrouveService;
import accesTag.TagService;
import dom.ObjetTrouve;
import dom.Tag;

@Stateless
@LocalBean
@Path("objetTrouve")
public class ObjetTrouveFacade {

	@EJB
	ObjetTrouveService objetTrouveService;
	@EJB
	TagService tagService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAnnonce(ObjetTrouveDTO objetTrouveDTO) throws Exception {

		ObjetTrouve objetTrouve = new ObjetTrouve();
		objetTrouve.setNom(objetTrouveDTO.getNom());
		objetTrouve.setAdresse(objetTrouveDTO.getAdresse());

		ArrayList<Tag> array = objetTrouveDTO.getTags();
		String tags = "";


		for(int i = 0; i < array.size(); i++){
			tagService.ajouter(array.get(i).getValue());
			tags += array.get(i).getValue();
			if(i < array.size()-1){
				tags += ",";
			}
		}
		objetTrouve.setTags(tags);


		objetTrouveService.creer(objetTrouve);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ObjetTrouveDTO> getLastAnnonces(){
		return null;
	}

}
