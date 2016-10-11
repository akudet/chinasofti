package hibernate_demo.db;

import hibernate_demo.vo.User;

import org.hibernate.Session;

public class SessionWrapper {

	Session mSession;

	public SessionWrapper(Session session) {
		super();
		this.mSession = session;
	}

	public void save(final Object object) {
		DBHelper.execute(new TransactionWork<Object>() {

			@Override
			public Object execute(Session session) {
				session.save(object);
				return null;
			}
			
		});
	}
	
	
}
