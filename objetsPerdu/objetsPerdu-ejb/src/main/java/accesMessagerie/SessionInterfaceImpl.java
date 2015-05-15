package accesMessagerie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dom.Annonce;
import dom.Message;
import dom.SessionMessage;

@Stateless
public class SessionInterfaceImpl implements SessionInterface {

	@PersistenceContext
	private EntityManager entityManager;
	


	@Override
	public List<Message> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public SessionMessage getSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
