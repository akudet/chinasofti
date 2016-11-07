package tp1.model.dao.abst.hb.db;

import org.hibernate.Session;

public interface TransactionWork<T> {
	
	public T execute(Session session);
	
}
