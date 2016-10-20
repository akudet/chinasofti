package demo.model.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import demo.model.dao.DAO;

public class SpringAbstractDAO<T> implements DAO<T> {
	public Class<T> voClass;
	
	public SpringAbstractDAO() {
		super();
	}

	@Autowired
	private SessionFactory sf;
	
	public SpringAbstractDAO(Class<T> voClass) {
		super();
		this.voClass = voClass;

	}

	private Session getSession() {
		return sf.openSession();
	}

	@Override
	public Serializable add(final T t) {
		return getSession().save(t);
	}

	@Override
	public void delete(final T t) {
		getSession().delete(t);
	}

	@Override
	public T find(final Serializable id) {
		return (T) getSession().get(voClass, id);
	}

	@Override
	public List<T> findAll() {
		return findAll("FROM " + voClass.getName());
	}

	@Override
	public List<T> findAll(final String query, final Object... params) {
		Query q = getSession().createQuery(query);
		
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}

		return q.list();
	}

	@Override
	public T findOne(String query, Object... params) {
		List<T> result = findAll(query, params);
		if (result.size() == 0) {
			return null;
		}
		return result.get(0);
	}

	@Override
	public void update(final T t) {
		getSession().update(t);
	}
}
