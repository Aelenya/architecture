package accesMessagerie;

import java.util.List;

import javax.ejb.Local;

import dom.Message;
import dom.SessionMessage;

@Local
public interface SessionInterface {
	
	public List<Message> getMessages();

	public SessionMessage getSession();
}
