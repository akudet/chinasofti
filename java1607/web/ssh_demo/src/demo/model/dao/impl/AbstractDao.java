package demo.model.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import demo.model.dao.Dao;
import demo.model.db.DBHelper;
import demo.model.db.TransactionWork;

public class AbstractDao<T> implements Dao<T> {

	public Class<?> voClass;

	public AbstractDao(Class<?> voClass) {
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
	public List<T> findAll(final String query) {
		return DBHelper.execute(new TransactionWork<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> execute(Session session) {
				return session.createQuery(query).list();
			}

		});
	}

	@Override
	public T findOne(final String query) {
		List<T> ts = findAll(query);
		if (ts.size() == 0) {
			return null;
		}
		return ts.get(0);
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
