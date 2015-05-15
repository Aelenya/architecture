package dom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ObjetPerdu extends Annonce implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column
	private String texteAnnonce;

	public String getTexteAnnonce() {
		return texteAnnonce;
	}
	public void setTexteAnnonce(String texteAnnonce) {
		this.texteAnnonce = texteAnnonce;
	}
	

}
