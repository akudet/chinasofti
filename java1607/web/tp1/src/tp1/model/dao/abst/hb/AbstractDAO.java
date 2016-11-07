package tp1.model.dao.abst.hb;

import tp1.model.dao.include.DAO;

public class AbstractDAO<T> extends HibernateAbstractDAO<T> implements DAO<T> {

	public AbstractDAO(Class<T> voClass) {
		super(voClass);
	}
	
}
