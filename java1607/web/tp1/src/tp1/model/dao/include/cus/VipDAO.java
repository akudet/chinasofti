package tp1.model.dao.include.cus;

import tp1.model.dao.include.DAO;
import tp1.model.vo.cus.Vip;

public interface VipDAO extends DAO<Vip> {

	/**
	 * 通过会员编号删除会员
	 * @param vipNo
	 * @return
	 */
	public int deleteByVipNo(int vipNo);

	/**
	 * 通过会员姓名查询
	 * @param name
	 * @return
	 */
	public Vip findOneByName(String name);

	/**
	 * 通过会员编号查询
	 * @param vipNo
	 * @return
	 */
	public Vip findOneByVipNo(String vipNo);

}
