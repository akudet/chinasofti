package tp1.model.dao.abst.hb.db;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * hibernate helper
 * @author 巫金桐
 *
 */
public class HBHelper {
	
	public static SessionFactory mSF = new AnnotationConfiguration().configure().buildSessionFactory();
	
	public static Session newSession() {
		return mSF.openSession();
	}
	
	public static <T> List<T> queryAll(final String query) {
		return execute(new TransactionWork<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> execute(Session session) {
				return (List<T>) session.createQuery(query).list();
			}

		});
	}
	
	public static <T>  T execute(TransactionWork<T> work) {
		Transaction tx = null;
		Session session = null;
		
		try {
			session = mSF.openSession();
			tx = session.beginTransaction();
			
			T result = work.execute(session);
			
			tx.commit();
			
			return result;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return null;
	}

}
