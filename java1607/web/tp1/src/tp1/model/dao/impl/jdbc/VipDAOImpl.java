package tp1.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp1.model.dao.AbstractDAO;
import tp1.model.dao.cus.VipDAO;
import tp1.model.dao.impl.jdbc.db.DBConnection;
import tp1.model.vo.cus.CusInfo;
import tp1.model.vo.cus.Vip;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipDAOImpl extends AbstractDAO<Vip> implements VipDAO {
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
	public ArrayList<Vip> findAll() {

		con = DBConnection.getConnection();
		String sql = "select * from vip";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<Vip> list = new ArrayList<Vip>();
			while (res.next()) {
				CusInfoDAO dao = new CusInfoDAO();
				CusInfo cusInfo = dao.findById(res.getString("cus_info_id"));
				Vip vip = new Vip(res.getInt("vip_no"), cusInfo);
				list.add(vip);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	@Override
	public List<Vip> findAll(int pageNo) {

		String sql = "selcet * from vip limit ?, ?";
		ArrayList<Vip> list = new ArrayList<Vip>();
		try {
			con = DBConnection.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, (pageNo - 1) * getPageCount());
			pre.setInt(2, getPageCount());
			res = pre.executeQuery();

			while (res.next()) {
				CusInfoDAO dao = new CusInfoDAO();
				CusInfo cusInfo = dao.findById(res.getString("cus_info_id"));
				Vip vip = new Vip(res.getInt("vip_no"), cusInfo);
				vip.setVipNo(res.getInt(1));
				list.add(vip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 按名字查
	public Vip findOneByName(String name) {

		con = DBConnection.getConnection();

		String sql = "select * from vip inner join cus_info on vip.cus_info_id = cus_info.cus_info_id where name = ?";

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			res = pre.executeQuery();
			if (res.next()) {
				Vip vip = new Vip(res.getInt("vip_no"),
						new CusInfoDAO().findById(res.getString("cus_info_id")));
				return vip;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	public Vip findOneByVipNo(String vipNumber) {

		con = DBConnection.getConnection();

		String sql = "select * from vip where vip_no = ?";

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, vipNumber);
			res = pre.executeQuery();
			if (res.next()) {
				Vip vip = new Vip(res.getInt("vip_no"),
						new CusInfoDAO().findById(res.getString("cus_info_id")));
				return vip;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
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
