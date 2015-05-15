package recherche;

import java.sql.Date;

public class RechercheDTO {
	private boolean objetPerdu;
	private String motCle;
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private String lieu;
	
	public boolean isObjetPerdu() {
		return objetPerdu;
	}
	public void setObjetPerdu(boolean objetPerdu) {
		this.objetPerdu = objetPerdu;
	}

	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}


	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


}
