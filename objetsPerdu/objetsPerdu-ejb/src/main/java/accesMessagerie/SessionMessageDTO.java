package accesMessagerie;

public class SessionMessageDTO {
	private long idSession;
	private String expediteur;
	private String destinataire;
	private String annonce;
	
	
	
	public long getIdSession() {
		return idSession;
	}
	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public String getAnnonce() {
		return annonce;
	}
	public void setAnnonce(String annonce) {
		this.annonce = annonce;
	}

}
