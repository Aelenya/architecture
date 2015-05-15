package objetPerdu;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import objetPerdu.ObjetPerduService;
import accesTag.TagService;
import dom.ObjetPerdu;
import dom.Tag;

@Stateless
@LocalBean
@Path("objetPerdu")
public class ObjetPerduFacade {

	@EJB
	ObjetPerduService objetPerduService;
	@EJB
	TagService tagService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAnnonce(ObjetPerduDTO objetPerduDTO) throws Exception {
		
		ObjetPerdu objetPerdu = new ObjetPerdu();
		objetPerdu.setNom(objetPerduDTO.getNom());
		objetPerdu.setTexteAnnonce(objetPerduDTO.getTexteAnnonce());
		objetPerdu.setAdresse(objetPerduDTO.getAdresse());
		objetPerdu.setDateCreation(new Date(Calendar.getInstance().getTimeInMillis()));
		
		ArrayList<Tag> array = objetPerduDTO.getTags();
		String tags = "";
		

		for(int i = 0; i < array.size(); i++){
			tagService.ajouter(array.get(i).getValue());
			tags += array.get(i).getValue();
			if(i < array.size()-1){
				tags += ",";
			}
		}
		objetPerdu.setTags(tags);
		objetPerdu.setSignale(false);
		
		objetPerduService.creer(objetPerdu);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lastAnnonces")
	public List<ObjetPerduDTO> getLastAnnonces(){
		List<ObjetPerdu> liste = objetPerduService.getLastAnnonces();
		List<ObjetPerduDTO> retour = new ArrayList<ObjetPerduDTO>();
		for(int i = 0; i < liste.size(); i++){
				ObjetPerduDTO obj = new ObjetPerduDTO();
				obj.setId(liste.get(i).getId());
				obj.setAdresse(liste.get(i).getAdresse());
				obj.setDateCreation(liste.get(i).getDateCreation());
				obj.setNom(liste.get(i).getNom());
				obj.setTexteAnnonce(liste.get(i).getTexteAnnonce());
				String tags = liste.get(i).getTags();
				ArrayList<Tag> tagsDTO = new ArrayList<Tag>();
				StringTokenizer st = new StringTokenizer(tags,",");
			     while (st.hasMoreTokens()) {
			         Tag t = new Tag();
			         t.setValue(st.nextToken());
			         tagsDTO.add(t);
			     }
				obj.setTags(tagsDTO);
				
				retour.add(obj);
		}
		return retour;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ObjetPerduDTO getAnnonce(@PathParam("id") long id){
		ObjetPerduDTO obj = new ObjetPerduDTO();
		ObjetPerdu o = objetPerduService.getAnnonce(id);
		obj.setId(o.getId());
		obj.setNom(o.getNom());
		obj.setTexteAnnonce(o.getTexteAnnonce());
		return obj;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/report/{id}")
	public void reportAnnonce(@PathParam("id") long id){
		objetPerduService.signale(id);
	}
		
}
