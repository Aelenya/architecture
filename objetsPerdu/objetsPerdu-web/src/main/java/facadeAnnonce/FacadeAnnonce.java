package facadeAnnonce;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dom.*;
import accesAnnonces.AnnoncesList;

@Stateless
@LocalBean
@Path("/lastPosts")
public class FacadeAnnonce {
	
	@Inject
	AnnoncesList access;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Annonce> getList(){
		return access.getList(0, 0);
	}
}
