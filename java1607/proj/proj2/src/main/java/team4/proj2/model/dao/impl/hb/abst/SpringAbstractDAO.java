package team4.proj2.model.dao.impl.hb.abst;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import team4.proj2.model.dao.DAO;
import team4.proj2.model.vo.ValueObject;

// TODO : the logic here really need improving
// I don't the the correct way for db operating when using spring
// From what I learned from class,
// this way is how they write the db access part
// open a session, and it should work, (though it's not)
// but I think it's not right. So i'm not sure.
public class SpringAbstractDAO<T extends ValueObject> implements DAO<T> {
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
	public String insert(final T t) {
		Session session = getSession();
		// need a transaction to wrap it
		Transaction ts = session.beginTransaction();
		// ValueObject using string as id, and this should work
		String id = session.save(t).toString();
		ts.commit();
		session.close();
		return id;
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
	public T find(final String id) {
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
