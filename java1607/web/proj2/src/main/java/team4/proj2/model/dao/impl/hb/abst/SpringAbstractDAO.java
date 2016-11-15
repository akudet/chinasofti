package team4.proj2.model.dao.impl.hb.abst;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import team4.proj2.model.dao.DAO;

public class SpringAbstractDAO<T> implements DAO<T> {
	public Class<T> voClass;

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
	public int add(final T t) {
		Session session = getSession();
		// need a transaction to wrap it
		Transaction ts = session.beginTransaction();
		session.save(t);
		ts.commit();
		session.close();
		return 0;
	}

	@Override
	public int delete(final T t) {
		Session session = getSession();
		session.delete(t);
		try {
			session.flush();
		} catch (Exception ignored) {
			// TODO : a better way
			// without this it terminated the program when delete an instance not exists
		}
		
		session.close();
		return 0;
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

	protected List<T> findAll(final String query, final Object... params) {
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

	protected T findOne(String query, Object... params) {
		List<T> result = findAll(query, params);
		if (result.size() == 0) {
			return null;
		}
		return result.get(0);
	}

	@Override
	public int update(final T t) {
		Session session = getSession();
		session.update(t);
		session.flush();
		session.close();
		return 0;
	}

	@Override
	public List<T> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalPage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
