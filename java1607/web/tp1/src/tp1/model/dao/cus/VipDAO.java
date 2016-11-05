package tp1.model.dao.cus;

import tp1.model.dao.DAO;
import tp1.model.vo.cus.Vip;

public interface VipDAO extends DAO<Vip> {

	public int deleteByVipNo(int vipNo);

	public Vip findOneByName(String name);

	public Vip findOneByVipNo(String vipNo);

}
