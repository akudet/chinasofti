package tp4.model.dao;

import java.util.List;

public abstract class DAO<T> {

	public abstract int add(T t);

	public abstract int deleteAll();

	public abstract int deleteById(String id);

	public abstract List<T> findAll();

	public abstract T findById(String id);

	public abstract int update(T t);
	
	public List<T> findAll(int pageNo) {
		return null;
	}
	
	public int getTotalPage() {
		return 0;
	}
}
