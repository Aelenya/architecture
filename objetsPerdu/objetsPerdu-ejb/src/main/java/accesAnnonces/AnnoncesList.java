package accesAnnonces;

import java.io.Serializable;
import java.util.List;

import dom.Annonce;

import javax.ejb.Local;

@Local
public interface AnnoncesList extends Serializable {
	List<Annonce> getList(long latitude, long longitude);
}
