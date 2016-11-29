package team4.proj2.model.dao.prod;

import java.util.List;

import team4.proj2.model.dao.DAO;
import team4.proj2.model.vo.prod.Product;

public interface ProductDAO extends DAO<Product> {
	// TODO : what if I want to handle of paging

	/**
	 * return latest products of a particular type
	 * 
	 * @param type
	 *            null for any type
	 * @return
	 */
	List<Product> latestProducts(String type);

	/**
	 * return popular products of a particular type
	 * 
	 * @param type
	 *            null for any type
	 * @return
	 */
	List<Product> popularProducts(String type);

	/**
	 * return a list of discounted products of a particular type
	 * 
	 * @param type
	 *            null for any type
	 * @return
	 */
	List<Product> discountProducts(String type);

}
