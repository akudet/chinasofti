package team4.proj2.model.dao;

import java.util.List;

/**
 * it holds which I implemented in AbstractDAO as a protected method
 * because it using sql, and break the abstraction enforced by DAO
 * @author Jintong Wu
 *
 */
public interface DAOHelper<T> {

	public T findOne(String sql, Object... params);
	
	public List<T> findAll(String sql, Object... params);
	
}
