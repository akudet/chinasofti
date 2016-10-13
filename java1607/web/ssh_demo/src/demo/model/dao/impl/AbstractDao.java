package demo.model.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import demo.model.dao.DAO;
import demo.model.db.DBHelper;
import demo.model.db.TransactionWork;

public class AbstractDAO<T> implements DAO<T> {

	public Class<T> voClass;

	public AbstractDAO(Class<T> voClass) {
		super();
		this.voClass = voClass;
	}

	@Override
	public Serializable add(final T t) {
		return DBHelper.execute(new TransactionWork<Serializable>() {

			@Override
			public Serializable execute(Session session) {
				return session.save(t);
			}

		});
	}

	@Override
	public void delete(final T t) {
		DBHelper.execute(new TransactionWork<Object>() {

			@Override
			public Object execute(Session session) {
				session.delete(t);
				return null;
			}

		});
	}

	@Override
	public T find(final Serializable id) {
		return DBHelper.execute(new TransactionWork<T>() {

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

	@Override
	public List<T> findAll(final String query, final Object... params) {
		List<T> result = DBHelper.execute(new TransactionWork<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> execute(Session session) {
				Query q = session.createQuery(query);

				if (null != params) {
					for (int i = 0; i < params.length; i++) {
						q.setEntity(i, params[i]);
					}
				}

				return q.list();
			}
		});

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
		DBHelper.execute(new TransactionWork<Object>() {

			@Override
			public Object execute(Session session) {
				session.update(t);
				return null;
			}

		});
	}

}
