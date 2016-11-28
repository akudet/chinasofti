package team4.proj2.model.dao.impl.hb.prod;

import org.springframework.stereotype.Repository;

import team4.proj2.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj2.model.dao.prod.SellerDAO;
import team4.proj2.model.vo.prod.Seller;

@Repository
public class SellerDAOImpl extends SpringAbstractDAO<Seller> implements SellerDAO {
	public SellerDAOImpl() {
		super(Seller.class);
	}

}
