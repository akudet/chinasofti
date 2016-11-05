package tp1.model.dao.impl.jdbc;

import tp1.model.dao.JDBCAbstractDAO;
import tp1.model.dao.cus.VipDAO;
import tp1.model.dao.impl.jdbc.mapper.impl.VipMapper;
import tp1.model.vo.cus.Vip;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipDAOImpl extends JDBCAbstractDAO<Vip> implements VipDAO {

	private static final String TABLE_NAME = "vip";

	public VipDAOImpl() {
		super(new VipMapper(), TABLE_NAME);
	}

	@Override
	public int add(Vip vip) {
		String sql = "insert into vip values(?,?)";
		new CusInfoDAO().add(vip);
		return update(sql, vip.getVipNo(), vip.getCusInfoId());
	}

	@Override
	public int deleteByVipNo(int vipNo) {
		String sql = "delete from vip where vip_no=?";
		return update(sql, vipNo);
	}

	@Override
	public Vip findOneByName(String name) {
		String sql = "select * from vip inner join cus_info on vip.cus_info_id = cus_info.cus_info_id where name = ?";
		return findOne(sql, name);
	}

	@Override
	public Vip findOneByVipNo(String vipNumber) {
		String sql = "select * from vip where vip_no = ?";
		return findOne(sql, vipNumber);
	}

	@Override
	public int update(Vip vip) {
		// vip only contains vip_no, and cus_info_id
		// vip_no can't change, and cus_info_id also can't change
		// so i't just update the CusInfo
		return new CusInfoDAO().update(vip);
	}

}
