package team4.proj2.model.dao.impl.hb;

import org.springframework.stereotype.Repository;

import team4.proj2.model.dao.ProductDAO;
import team4.proj2.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj2.model.vo.Product;

@Repository
public class ProductDAOImpl extends SpringAbstractDAO<Product> implements ProductDAO {
	public ProductDAOImpl() {
		super(Product.class);
	}
}
