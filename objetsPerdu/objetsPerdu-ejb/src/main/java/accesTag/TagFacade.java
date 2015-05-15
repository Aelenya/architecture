package accesTag;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@LocalBean
@Path("cloud")
public class TagFacade {

	@EJB
	TagService tagService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TagDTO> getTags(){
		List<String> liste = tagService.getListe();
		List<TagDTO> retour = new ArrayList<TagDTO>();
		
		for(int i = 0; i < liste.size(); i++){
			TagDTO tag = new TagDTO();
			tag.setValue(liste.get(i));
			retour.add(tag);
		}
		return retour;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/autocomplete")
	public List<TagDTO> getCompleteTags(){
		List<String> liste = tagService.getBigListe();
		List<TagDTO> retour = new ArrayList<TagDTO>();
		
		for(int i = 0; i < liste.size(); i++){
			TagDTO tag = new TagDTO();
			tag.setValue(liste.get(i));
			retour.add(tag);
		}
		return retour;
	}
}
