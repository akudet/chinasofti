package team4.proj1.model.dao.impl.hb.abst.db;

import org.hibernate.Session;

public interface TransactionWork<T> {
	
	public T execute(Session session);
	
}
