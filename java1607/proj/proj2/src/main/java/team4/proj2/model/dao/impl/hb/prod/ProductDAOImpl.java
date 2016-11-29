package team4.proj2.model.dao.impl.hb.prod;

import java.util.List;

import org.springframework.stereotype.Repository;

import team4.proj2.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj2.model.dao.prod.ProductDAO;
import team4.proj2.model.vo.prod.Product;

@Repository
public class ProductDAOImpl extends SpringAbstractDAO<Product> implements ProductDAO {
	public ProductDAOImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> latestProducts(String type) {
		return findAll("FROM Product WHERE type=? ORDER BY onSaleTime", type);
	}

	@Override
	public List<Product> popularProducts(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> discountProducts(String type) {
		// TODO Auto-generated method stub
		return null;
	}
}
