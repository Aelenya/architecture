package accesProfil;

import java.io.Serializable;

import javax.ejb.Local;

@Local
public interface GestionnaireProfilService extends Serializable {

	/**
	 * mets a jour/change le mot de passe
	 * 
	 * @param nouveau
	 *            mot de passe
	 * @param pseudo
	 *            pseudo
	 */
	public void modifierMotDePasse(String nouveau, String pseudo);

	/**
	 * mets a jour/change l'adresse mail
	 * 
	 * @param nouvelle
	 *            adresse mail
	 * @param pseudo
	 *            pseudo
	 */
	public void modifierAdresseMail(String nouveau, String pseudo);

	/**
	 * Supprime l'utilisateur
	 * 
	 * @param pseudo
	 */
	public void supprimer(String pseudo);

}
