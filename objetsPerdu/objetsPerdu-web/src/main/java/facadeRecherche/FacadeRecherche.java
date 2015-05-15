package facadeRecherche;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dom.ObjetPerdu;
import recherche.RechercheService;

@Stateless
@LocalBean
@Path("facadeRecherche")
public class FacadeRecherche {

	@Inject
	RechercheService rs;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{mc}/{date}/{lieu}")
	public List<ObjetPerdu> getMessagesSession(@PathParam("mc") String mc, @PathParam("date") Date date, @PathParam("lieu") String lieu){
		List<ObjetPerdu> resObjetPerdu = rs.rechercheObjetPerdu(mc, date, lieu);
		return resObjetPerdu;
	}
}