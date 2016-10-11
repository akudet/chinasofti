package hibernate_demo.db;

import org.hibernate.Session;

public interface TransactionWork<T> {
	
	public T execute(Session session);
	
}
