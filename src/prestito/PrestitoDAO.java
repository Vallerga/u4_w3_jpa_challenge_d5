package prestito;

import javax.persistence.EntityManager;

import utils.JpaUtil;

public class PrestitoDAO {
	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
}
