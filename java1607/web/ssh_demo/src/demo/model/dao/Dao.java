package demo.model.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

	public Serializable add(T t);

	public void delete(T t);

	public T find(Serializable id);

	public List<T> findAll(String query);

	public T findOne(String query);

	public void update(T t);

}
