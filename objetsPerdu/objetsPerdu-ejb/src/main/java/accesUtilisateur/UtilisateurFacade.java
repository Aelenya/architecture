package accesUtilisateur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dom.Utilisateur;

@Stateless
@LocalBean
@Path("inscription")
public class UtilisateurFacade {

	@EJB
	UtilisateurService utilisateurService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response makeInscription(UtilisateurDTO utilisateurDTO) throws Exception{

		//Avant de construire un nouvel utilisateur, on check le resultat du captcha
		final String key = "6Ld5zQYTAAAAAGd-thXY-7WXWCpX5vsS1Nn2GChP";
		final String response = utilisateurDTO.getResponse();
		boolean valide = false;
		URL url = new URL("https://www.google.com/recaptcha/api/siteverify?secret="+key+"&response="+response);
		InputStream is = url.openStream();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String json = readAll(br);
			if(json.contains("true")){
				valide = true;
			}
		}finally{
			is.close();
		}
		
		if(utilisateurService.rechercheEmail(utilisateurDTO.getEmail())){
			return Response.serverError().entity("Cette adresse mail est déjà utilisée").build();
		}
		if(!valide){
			return Response.serverError().entity("Captcha invalide").build();
		}
		if( !(utilisateurDTO.getPassword().equals(utilisateurDTO.getConfirmPassword())) ){
			System.out.println(utilisateurDTO.getPassword().length());
			System.out.println(utilisateurDTO.getConfirmPassword().length());
			return Response.serverError().entity("La confirmation du password ne correspond pas").build();
		}
		if( !utilisateurDTO.getEmail().equals(utilisateurDTO.getConfirmMail()) ){
			System.out.println(utilisateurDTO.getEmail());
			System.out.println(utilisateurDTO.getConfirmMail());
			return Response.serverError().entity("La confirmation de l'email ne correspond pas").build();
		}
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(utilisateurDTO.getEmail());
		utilisateur.setPseudo(utilisateurDTO.getPseudo());
		utilisateur.setPassword(utilisateurDTO.getPassword());
		utilisateurService.creer(utilisateur);
		return Response.ok(utilisateur, MediaType.APPLICATION_JSON).build();
	}

	//Methodes simple de lecture via un BufferedReader, retourne le JSON obtenu via reCAPTCHA
	private static String readAll(BufferedReader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String[] getInfos(){
		return null;
	}

}
