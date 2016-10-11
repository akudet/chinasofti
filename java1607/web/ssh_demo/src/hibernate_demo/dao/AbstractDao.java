package hibernate_demo.dao;

import hibernate_demo.db.DBHelper;
import hibernate_demo.db.TransactionWork;
import hibernate_demo.vo.User;

import java.util.List;

import org.hibernate.Session;

public class AbstractDao<T> implements Dao<T> {

	public Class<?> voClass;

	public AbstractDao(Class<?> voClass) {
		super();
		this.voClass = voClass;
	}

	public void add(final T t) {
		DBHelper.execute(new TransactionWork<T>() {

			@Override
			public T execute(Session session) {
				session.save(t);
				return null;
			}

		});
	}

	public void delete(final T t) {
		DBHelper.execute(new TransactionWork<Object>() {

			@Override
			public Object execute(Session session) {
				session.delete(t);
				return null;
			}

		});
	}

	public T find(final int id) {
		return DBHelper.execute(new TransactionWork<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public T execute(Session session) {
				return (T) session.get(voClass, id);
			}

		});
	}

	public List<T> findAll(final String query) {
		return DBHelper.execute(new TransactionWork<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> execute(Session session) {
				return session.createQuery(query).list();
			}

		});
	}

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
