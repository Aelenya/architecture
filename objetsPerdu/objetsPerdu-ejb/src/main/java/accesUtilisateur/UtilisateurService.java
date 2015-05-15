package accesUtilisateur;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dom.Annonce;
import dom.Message;
import dom.Utilisateur;

@Stateless
public class UtilisateurService {

	@PersistenceContext(unitName = "basePersistence")
	private EntityManager em;

	public boolean rechercheEmail(String email) {
		Query q = em
				.createQuery("SELECT u.email FROM Utilisateur u WHERE u.email = :email");
		q.setParameter("email", email);
		return !q.getResultList().isEmpty();

	}

	public boolean recherchePseudo(String pseudo) {
		Query q = em
				.createQuery("SELECT TRUE FROM Utilisateur as U WHERE U.pseudo = :pseudo");
		q.setParameter("pseudo", pseudo);
		return !q.getResultList().isEmpty();
	}

	public void creer(Utilisateur utilisateur) throws NoSuchAlgorithmException {

		String pwd = utilisateur.getPassword();
		//pwd = pwd.substring(0), pwd.length()-1);
		pwd = getMD5Hash(pwd); 
		utilisateur.setPassword(pwd);
		utilisateur.setGroupe("User");
		em.persist(utilisateur);

		/*
		 * String qu =
		 * "SELECT MD5(\"".concat(utilisateur.getPassword()).concat("\")");
		 * Query q = em.createNativeQuery(qu); utilisateur.setGroupe("User");
		 * String pwd = q.getSingleResult().toString();
		 * utilisateur.setPassword(pwd);
		 * 
		 * em.persist(utilisateur);
		 */

	}

	public void supprimer(Utilisateur utilisateur) {
		em.remove(em.merge(utilisateur));
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

	public List<Utilisateur> getListUtilisateurs() {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> c = qb.createQuery(Utilisateur.class);
		TypedQuery<Utilisateur> query = em.createQuery(c);
		return query.getResultList();
	}

	public Utilisateur getUtilisateurByPseudo(String pseudo) {
		Query q = em.createQuery("SELECT U FROM Utilisateur as U WHERE U.pseudo = :pseudo");
		q.setParameter("pseudo", pseudo);
		if (!q.getResultList().isEmpty()) {
			return (Utilisateur) q.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Utilisateur getUtilisateurByEmail(String email) {
		Query q = em.createQuery("SELECT U FROM Utilisateur as U WHERE U.email = :email");
		q.setParameter("email", email);
		if (!q.getResultList().isEmpty()) {
			return (Utilisateur) q.getResultList().get(0);
		} else {
			return null;
		}
	}
}
