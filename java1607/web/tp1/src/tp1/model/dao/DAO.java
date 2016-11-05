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
	 * 
	 * @param pageNo
	 * @return
	 *   all resource at pageNo
	 */
	public List<T> findAll(int pageNo);

}