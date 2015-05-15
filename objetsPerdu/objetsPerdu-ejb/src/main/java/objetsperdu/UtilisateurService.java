package objetsperdu;
/*
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ejb.dom.Utilisateur;

@Stateless(name="utilisateurService")
public class UtilisateurService {
	
	@PersistenceContext(unitName = "basePersistence")
	private EntityManager em;
	
	public boolean rechercheEmail(String email) throws ExceptionUser{
		try{
			Query q = em.createQuery("SELECT u.email FROM Utilisateur u WHERE u.email = :email");
			q.setParameter("email",email);
			return !q.getResultList().isEmpty();
		}
		catch(Exception ex){ 
			throw new ExceptionUser(ex.getMessage(),"FIND_ERROR"); 
		}
	}
	
	public boolean recherchePseudo(String pseudo) throws ExceptionUser{
		try{
			Query q = em.createQuery("SELECT TRUE FROM Utilisateur as U WHERE U.pseudo = :pseudo");
			q.setParameter("pseudo", pseudo);
			return !q.getResultList().isEmpty();
		}
		catch(Exception ex){ 
			throw new ExceptionUser(ex.getMessage(),"FIND_ERROR"); 
		}
	}
	
	public void creer(Utilisateur utilisateur) throws ExceptionUser{
		try{
			String pwd = getMD5Hash(utilisateur.getPassword());
			utilisateur.setPassword( pwd );
			utilisateur.setGroupe("User");
			em.persist(utilisateur);
		}
		catch(Exception ex){ 
			throw new ExceptionUser(ex.getMessage(),"PERSIST_ERROR");
			}
	}
	
	public void supprimer(Utilisateur utilisateur) throws ExceptionUser{
		try{
			em.remove(em.merge(utilisateur));
		}
		catch(Exception ex){ 
			throw new ExceptionUser(ex.getMessage(),"REMOVE_ERROR"); 
		}
	}
	
	public static String getMD5Hash(String s) throws NoSuchAlgorithmException{

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
		return result; }
}
*/