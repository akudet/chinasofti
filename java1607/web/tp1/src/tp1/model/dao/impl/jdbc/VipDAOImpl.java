package tp1.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp1.model.dao.JDBCAbstractDAO;
import tp1.model.dao.cus.VipDAO;
import tp1.model.dao.impl.jdbc.db.DBConnection;
import tp1.model.vo.cus.CusInfo;
import tp1.model.vo.cus.Vip;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipDAOImpl extends JDBCAbstractDAO<Vip> implements VipDAO {
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;

	// 添加数据
	public int add(Vip vip) {
		new CusInfoDAO().add(vip, vip.getCusType().getCusTypeNo());
		con = DBConnection.getConnection();
		String sql = "insert into vip values(?,?)";
		try {
			pre = con.prepareStatement(sql);

			pre.setInt(1, vip.getVipNo());
			pre.setString(2, vip.getCusInfoId());

			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	// 删除数据
	public int deleteByVipNo(int vipNumber) {
		con = DBConnection.getConnection();
		String sql = "select * from vip where vip_no= ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, vipNumber);
			res = pre.executeQuery();
			if (res.next()) {
				CusInfoDAO dao = new CusInfoDAO();
				pre = con.prepareStatement("delete from vip where vip_no=?");
				pre.setInt(1, vipNumber);
				pre.executeUpdate();
				dao.deleteById(res.getString("cus_info_id"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	// 查询数据
	@Override
	public List<Vip> findAll() {
		return findAll("select * from vip");
	}

	@Override
	public List<Vip> findAll(int pageNo) {
		String sql = "selcet * from vip limit ?, ?";
		int start = (pageNo - 1) * getPageCount();

		return findAll(sql, start, getPageCount());
	}

	// 按名字查
	@Override
	public Vip findOneByName(String name) {
		String sql = "select * from vip inner join cus_info on vip.cus_info_id = cus_info.cus_info_id where name = ?";
		return findOne(sql, name);
	}

	public Vip findOneByVipNo(String vipNumber) {
		String sql = "select * from vip where vip_no = ?";
		return findOne(sql, vipNumber);
	}

	@Override
	public int getTotalPage() {
		int count = 0;
		String sql = "select count(*) from vip";

		try {
			con = DBConnection.getConnection();
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();

			while (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = (int) Math.ceil((count + 1.0 - 1.0) / getPageCount());
		return count;

	}

	// 修改
	@Override
	public int update(Vip vipNumber) {
		con = DBConnection.getConnection();
		String sql = "update vip set cus_info_id where vip_no = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, vipNumber.getVipNo());
			pre.setString(2, vipNumber.getCusInfoId());

			
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return 0;
	}

}
