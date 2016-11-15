package team4.proj1.model.dao.include;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> {

	/**
	 * add a resource to db
	 * 
	 * @param vo
	 *            the resource to add
	 * @return 0 for success, other for failure
	 */
	public int add(T vo);

	/**
	 * delete one resource from database where it's primary key is equals t's
	 * primary key
	 * 
	 * @param t
	 * @return
	 */
	public int delete(T t);

	/**
	 * find a resource by it's primary key, the key def is depends on hibernate
	 * definition
	 * 
	 * @param id
	 * @return
	 */
	public T find(Serializable id);

	/**
	 * find all resources in the database
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 
	 * @param pageNo
	 * @return all resource at pageNo
	 */
	public List<T> findAll(int pageNo);

	/**
	 * 
	 * @return how many entry per page
	 */
	public int getPageCount();

	/**
	 * 
	 * @return total number of page
	 */
	public int getTotalPage();

	/**
	 * update the db version of the resource
	 * 
	 * @param vo
	 * @return
	 */
	public int update(T vo);

}