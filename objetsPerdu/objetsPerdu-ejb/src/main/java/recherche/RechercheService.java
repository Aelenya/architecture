package recherche;

import java.sql.Date;
import java.util.List;

import dom.ObjetPerdu;

public interface RechercheService{
	public List<ObjetPerdu> rechercheObjetPerdu(RechercheDTO recherche);

	public List<ObjetPerdu> rechercheObjetPerdu(String mc, Date date,
			String lieu);
}
