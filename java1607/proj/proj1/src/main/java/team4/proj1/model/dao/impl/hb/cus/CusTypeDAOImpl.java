package team4.proj1.model.dao.impl.hb.cus;

import org.springframework.stereotype.Repository;

import team4.proj1.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj1.model.dao.include.cus.CusTypeDAO;
import team4.proj1.model.vo.cus.CusType;

@Repository
public class CusTypeDAOImpl extends SpringAbstractDAO<CusType> implements CusTypeDAO {

	public CusTypeDAOImpl() {
		super(CusType.class);
	}
	
}
