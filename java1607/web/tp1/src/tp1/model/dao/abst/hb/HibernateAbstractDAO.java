package tp1.model.dao.abst.hb;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tp1.model.dao.abst.hb.db.HBHelper;
import tp1.model.dao.abst.hb.db.TransactionWork;
import tp1.model.dao.include.DAO;

public class HibernateAbstractDAO<T> implements DAO<T> {

	public Class<T> voClass;

	public HibernateAbstractDAO(Class<T> voClass) {
		super();
		this.voClass = voClass;
	}

	@Override
	public int add(final T t) {
		return HBHelper.execute(new TransactionWork<Integer>() {

			@Override
			public Integer execute(Session session) {
				session.save(t);
				return 0;
			}

		});
	}

	@Override
	public int delete(final T t) {
		return HBHelper.execute(new TransactionWork<Integer>() {

			@Override
			public Integer execute(Session session) {
				session.delete(t);
				return 0;
			}

		});
	}

	@Override
	public T find(final Serializable id) {
		return HBHelper.execute(new TransactionWork<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public T execute(Session session) {
				return (T) session.get(voClass, id);
			}

		});
	}

	@Override
	public List<T> findAll() {
		return findAll("FROM " + voClass.getName());
	}

	// TODO : if using session.createSQLQuery is it possible for jdbc impl also work
	protected List<T> findAll(final String query, final Object... params) {
		List<T> result = HBHelper.execute(new TransactionWork<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> execute(Session session) {
				Query q = session.createQuery(query);

				if (null != params) {
					for (int i = 0; i < params.length; i++) {
						q.setParameter(i, params[i]);
					}
				}

				return q.list();
			}
		});

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
		return HBHelper.execute(new TransactionWork<Integer>() {

			@Override
			public Integer execute(Session session) {
				session.update(t);
				return 0;
			}

		});
	}

	@Override
	public int getPageCount() {
		return 0;
	}

	@Override
	public int getTotalPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
