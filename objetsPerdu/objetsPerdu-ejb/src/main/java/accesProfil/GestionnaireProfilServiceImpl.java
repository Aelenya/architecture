package accesProfil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/*import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;*/
/*import javax.persistence.criteria.CriteriaUpdate;*/





import dom.Utilisateur;

@Stateless
public class GestionnaireProfilServiceImpl implements GestionnaireProfilService {

	private static final long serialVersionUID = -6380968897175065474L;
	@PersistenceContext(unitName = "basePersistence")
	private EntityManager em;

	@Override
	public void modifierMotDePasse(String nouveau, String pseudo) {
		Query querry=em.createQuery("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo");
		querry.setParameter("pseudo",pseudo);
		Utilisateur utilisateur = (Utilisateur) querry.getResultList().get(0);
		nouveau = nouveau.substring(0, nouveau.length()-1);
		try {
			nouveau = getMD5Hash(nouveau);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utilisateur.setPassword(nouveau);
	}

	@Override
	public void modifierAdresseMail(String nouveau, String pseudo) {
		Query querry=em.createQuery("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo");
		querry.setParameter("pseudo",pseudo);
		Utilisateur utilisateur = (Utilisateur) querry.getResultList().get(0);
		utilisateur.setEmail(nouveau);
	}

	@Override
	public void supprimer(String pseudo) {
		Query querry=em.createQuery("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo");
		querry.setParameter("pseudo",pseudo);
		Utilisateur utilisateur = (Utilisateur) querry.getResultList().get(0);
		em.remove(utilisateur);
	}
	
	public static String getMD5Hash(String s) throws NoSuchAlgorithmException {

		String result = s;
		if (s != null) {

			MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA-1"
			md.update(s.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			result = hash.toString(16);
			while (result.length() < 32) { // 40 for SHA-1
				result = "0" + result;
			}

		}
		return result;
	}

}