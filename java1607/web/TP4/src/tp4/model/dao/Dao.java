package tp4.model.dao;

import java.util.List;

public interface Dao<T> {

	public abstract int add(T t);

	public abstract int deleteAll();

	public abstract int deleteById();

	public abstract List<T> findAll();

	public abstract T findById(String id);

	public abstract int update(T t);
}
