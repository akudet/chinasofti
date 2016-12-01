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
		if (null == type || type.equals("")) {
			type="%";
		}
		return findAll("FROM Product WHERE type like ? ORDER BY onSaleTime DESC", type);
	}

	@Override
	public List<Product> popularProducts(String type) {
		if (null == type || type.equals("")) {
			type="%";
		}
		return findAll("FROM Product WHERE type like ? ORDER BY sells DESC", type);
	}

	@Override
	public List<Product> discountProducts(String type) {
		if (null == type || type.equals("")) {
			type="%";
		}
		// it took me 3 hrs to figure it out, I should write sth like this
		return findAll("SELECT DISTINCT product FROM StockInfo");
	}
}
