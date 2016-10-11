package hibernate_demo.dao;

import java.util.List;

public interface Dao<T> {

	public void add(T t);

	public void delete(T t);

	public T find(int id);

	public List<T> findAll(String query);
	
	public void update(T t);

}
