package tp1.model.dao.impl.jdbc.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp1.model.dao.impl.jdbc.CusInfoDAO;
import tp1.model.dao.impl.jdbc.mapper.Mapper;
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
