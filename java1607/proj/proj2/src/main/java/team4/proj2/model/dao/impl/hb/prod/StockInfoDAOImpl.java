package team4.proj2.model.dao.impl.hb.prod;

import org.springframework.stereotype.Repository;

import team4.proj2.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj2.model.dao.prod.StockInfoDAO;
import team4.proj2.model.vo.prod.StockInfo;

@Repository
public class StockInfoDAOImpl extends SpringAbstractDAO<StockInfo> implements StockInfoDAO {
	public StockInfoDAOImpl() {
		super(StockInfo.class);
	}
}
