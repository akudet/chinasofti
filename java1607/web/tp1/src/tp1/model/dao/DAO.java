package tp1.model.dao;

import java.util.List;

public interface DAO<T> {

	/**
	 * add a resource to db
	 * @param vo the resource to add
	 * @return
	 *   0 for success, other for failure
	 */
	public int add(T vo);

	/**
	 * delete a resource from db
	 * @param vo
	 * @return
	 *   0 for success, other for failure
	 */
	public int delete(T vo);

	/**
	 * 
	 * @param id
	 * @return
	 *   null for not find
	 */
	public T find(int id);

	/**
	 * find all resources in the database
	 * @return
	 */
	public List<T> findAll();

	/**
	 * update the db version of the resource
	 * @param vo
	 * @return
	 */
	public int update(T vo);

}