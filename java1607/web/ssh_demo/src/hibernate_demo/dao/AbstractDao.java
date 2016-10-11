package hibernate_demo.dao;

import hibernate_demo.db.DBHelper;

import java.util.List;

public class AbstractDao<T> implements Dao<T> {
	
	public List<T> list() {
		return null;
	}

}
