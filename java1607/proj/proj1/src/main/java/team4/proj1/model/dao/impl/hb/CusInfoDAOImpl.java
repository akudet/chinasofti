package team4.proj1.model.dao.impl.hb;

import org.springframework.stereotype.Repository;

import team4.proj1.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj1.model.dao.include.cus.CusInfoDAO;
import team4.proj1.model.vo.cus.CusInfo;

@Repository
public class CusInfoDAOImpl extends SpringAbstractDAO<CusInfo> implements
		CusInfoDAO {

	public CusInfoDAOImpl() {
		super(CusInfo.class);
	}

}
