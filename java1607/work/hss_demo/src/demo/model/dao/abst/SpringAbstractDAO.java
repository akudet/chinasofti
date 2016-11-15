package demo.model.dao.abst;

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
		Session session = getSession();
		Serializable id = session.save(t);
		session.close();
		return id;
	}

	@Override
	public void delete(final T t) {
		Session session = getSession();
		session.delete(t);
		try {
			session.flush();
		} catch (Exception ignored) {
			// TODO : a better way
			// without this it terminated the program when delete an instance not exists
		}
		
		session.close();
	}

	@Override
	public T find(final Serializable id) {
		Session session = getSession();
		@SuppressWarnings("unchecked")
		T t = (T) session.get(voClass, id);
		session.close();
		return t;
	}

	@Override
	public List<T> findAll() {
		return findAll("FROM " + voClass.getName());
	}

	@Override
	public List<T> findAll(final String query, final Object... params) {
		Session session = getSession();
		Query q = session.createQuery(query);
		
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}

		@SuppressWarnings("unchecked")
		List<T> result = q.list();
		session.close();
		
		return result;
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
		Session session = getSession();
		session.update(t);
		session.flush();
		session.close();
	}
}
