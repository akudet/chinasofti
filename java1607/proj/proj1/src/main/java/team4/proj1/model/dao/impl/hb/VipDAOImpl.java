package team4.proj1.model.dao.impl.hb;

import org.springframework.stereotype.Repository;

import team4.proj1.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj1.model.dao.include.cus.VipDAO;
import team4.proj1.model.vo.cus.Vip;

@Repository
public class VipDAOImpl extends SpringAbstractDAO<Vip> implements VipDAO {
	
	public VipDAOImpl() {
		super(Vip.class);
	}

	@Override
	public int deleteByVipNo(int vipNo) {
		Vip vip = new Vip();
		vip.setVipNo(vipNo);
		return delete(vip);
	}

	@Override
	public Vip findOneByName(String name) {
		return findOne("FROM Vip WHERE name=?", name);
	}

	@Override
	public Vip findOneByVipNo(String vipNo) {
		return find(Integer.parseInt(vipNo));
	}

}
