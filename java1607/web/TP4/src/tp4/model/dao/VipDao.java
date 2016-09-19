package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tp4.model.db.DBConnection;
import tp4.model.vo.CusInfo;
import tp4.model.vo.Vip;
import tp4.model.vo.Checkin;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipDao extends DAO<Vip>{
	private static final int DATE_PAGE = 5;
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	@Override
	public List<Vip> findAll(int pageNo) {
		
		String sql = "selcet * from vip limit ?, ?";
		ArrayList<Vip> list = new ArrayList<Vip>();
		try {
			con = DBConnection.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, (pageNo - 1) * DATE_PAGE);
			pre.setInt(2, DATE_PAGE);
			res = pre.executeQuery();
			
			while(res.next()){
				CusInfoDao dao = new CusInfoDao();
				CusInfo cusInfo = dao.findById(res.getString("cus_info_id"));
				Vip vip = new Vip(res.getInt("vip_no"), cusInfo);
				vip.setCusInfo(cusInfo);
				vip.setVipNo(res.getInt(1));
				list.add(vip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
		count = (int) Math.ceil((count + 1.0 - 1.0) / DATE_PAGE);
		return count;
		
	}

	// 添加数据
	public int add(Vip vip) {
		new CusInfoDao().add(vip.getCusInfo(), vip.getCusInfo().getCusType()
				.getCusTypeNo());
		con = DBConnection.getConnection();
		String sql = "insert into vip values(?,?)";
		try {
			pre = con.prepareStatement(sql);

			pre.setInt(1, vip.getVipNo());
			pre.setString(2, vip.getCusInfo().getCusInfoId());

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
	public int deleteById(int vipNumber) {
		con = DBConnection.getConnection();
		String sql = "select * from vip where vip_no= ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, vipNumber);
			res = pre.executeQuery();
			if (res.next()) {
				CusInfoDao dao = new CusInfoDao();
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
				CusInfoDao dao = new CusInfoDao();
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

	// 通过客户Id查找
	public int findByCusInfoId(String cusInfoId) {
		con = DBConnection.getConnection();
		String sql = "select vip_no from vip where cus_info_id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, cusInfoId);
			res = pre.executeQuery();
			if (res.next()) {
				Vip vip = new Vip();
				vip.setVipNo(res.getInt("vip_no"));
				return vip.getVipNo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return 0;
	}

	public Vip findById(String vipNumber) {

		con = DBConnection.getConnection();

		String sql = "select * from vip where vip_no = ?";

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, vipNumber);
			res = pre.executeQuery();
			if (res.next()) {
				Vip vip = new Vip();
				vip.setVipNo(res.getInt("vip_no"));
				vip.setCusInfo(new CusInfoDao().findById(res
						.getString("cus_info_id")));
				return vip;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// 修改

	public int update(Vip vipNumber) {
		con = DBConnection.getConnection();
		String sql = "update vip set cus_info_id where vip_no = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, vipNumber.getVipNo());
			pre.setString(2, vipNumber.getCusInfo().getCusInfoId());

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

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
