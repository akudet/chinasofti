package demo.model.dao.abst;

import demo.model.dao.DAO;

public class AbstractDAO<T> extends HibernateAbstractDAO<T> implements DAO<T> {

	public AbstractDAO(Class<T> voClass) {
		super(voClass);
	}
	
}
