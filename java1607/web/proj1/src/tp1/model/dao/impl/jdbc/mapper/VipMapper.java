package tp1.model.dao.impl.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp1.model.dao.impl.jdbc.CusInfoDAO;
import tp1.model.dao.impl.jdbc.abst.Mapper;
import tp1.model.vo.cus.CusInfo;
import tp1.model.vo.cus.Vip;

public class VipMapper implements Mapper<Vip> {

	@Override
	public Vip map(ResultSet rs) throws SQLException {
		CusInfo cusInfo = new CusInfoDAO().findById(rs.getString("cus_info_id"));
		Vip vip = new Vip(rs.getInt("vip_no"), cusInfo);
		return vip;
	}

}
