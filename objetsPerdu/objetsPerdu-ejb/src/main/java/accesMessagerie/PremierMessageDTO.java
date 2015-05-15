package accesMessagerie;

public class PremierMessageDTO {
	/*
	 * Dans le cas ou c'est un premier message, il y a plus d'information
	 * pusique ce premier message contient egalement l'expediteur et le destinataire
	 */
	
	private String texte;
	private String destinataire;
	private String expediteur;
	private long idAnnonce;

	public String getTexte() {
		return texte;
	}
	
	public String getDestinataire() {
		return destinataire;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public long getIdAnnonce() {
		return idAnnonce;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public void setIdAnnonce(long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	

}
