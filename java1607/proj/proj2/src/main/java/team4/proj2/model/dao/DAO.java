package team4.proj2.model.dao;

import java.util.List;

import team4.proj2.model.vo.ValueObject;

public interface DAO<T extends ValueObject> {

	/**
	 * add a resource to db
	 * 
	 * @param vo
	 *            the resource to add
	 * @return the id of the inserted ValueObject
	 */
	public String insert(T vo);

	/**
	 * find a resource by it's primary key, the key def is depends on hibernate
	 * definition
	 * 
	 * @param id
	 * @return
	 */
	public T find(String id);

	/**
	 * update the db version of the resource
	 * 
	 * @param vo
	 * @return 0 for success other for failure
	 */
	public int update(T vo);

	/**
	 * delete one resource from database where it's primary key is equals t's
	 * primary key
	 * 
	 * @param t
	 * @return 0 for success other for failure
	 */
	public int delete(T t);

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

}