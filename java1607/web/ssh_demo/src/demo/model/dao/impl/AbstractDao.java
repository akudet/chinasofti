package demo.model.dao.impl;

import demo.model.dao.DAO;

public class AbstractDAO<T> extends HibernateAbstractDAO<T> implements DAO<T> {

	public AbstractDAO(Class<T> voClass) {
		super(voClass);
	}
	
}
