package demo.controller.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<T> {
	
	public Serializable add(T t);

	public void delete(T t);

	public T find(Serializable id);

	public List<T> findAll();

	public void update(T t);
}
