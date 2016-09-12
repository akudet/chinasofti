package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp4.model.db.DBConnection;
import tp4.model.vo.CusInfo;

/**
 * 
 * @author 项双江
 * 
 */
public class CusInfoDao {
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;

	// 增加
	public int add(CusInfo cusInfo, int cusTypeNo) {
		con = DBConnection.getConnection();
		String sql = "insert into cus_info values(?,?,?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, cusInfo.getCusInfoId());
			pre.setString(2, cusInfo.getCertType());
			pre.setString(3, cusInfo.getCertNumber());
			pre.setString(4, cusInfo.getName());
			pre.setString(5, cusInfo.getPhone());
			pre.setString(6, cusInfo.getAddresss());
			pre.setString(7, cusInfo.getSex());
			pre.setInt(8, cusTypeNo);
			pre.setString(9, cusInfo.getComment());
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

	// 删除
	public int deleteById(String cusInfoId) {
		con = DBConnection.getConnection();
		String sql = "delete from cus_info where cus_info_id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, cusInfoId);
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

	// 全查询
	public ArrayList<CusInfo> findAll() {
		con = DBConnection.getConnection();
		String sql = "select * from cus_info";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<CusInfo> list = new ArrayList<CusInfo>();
			while (res.next()) {
				int cusTypeNo = res.getInt("cus_type_no");

				CusInfo cusInfo = new CusInfo(res.getString("cus_info_id"),
						res.getString("cert_type"),
						res.getString("cert_number"), res.getString("name"),
						res.getString("phone"), res.getString("address"),
						res.getString("sex"), res.getString("comment"));
				CusTypeDao dao = new CusTypeDao();
				cusInfo.setCusType(dao.findById(cusTypeNo));
				list.add(cusInfo);
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

	// 单查询
	public CusInfo findById(String cusInfoId) {
		con = DBConnection.getConnection();
		String sql = "select * from cus_info where cus_info_id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, cusInfoId);
			res = pre.executeQuery();
			if (res.next()) {
				int cusTypeNo = res.getInt("cus_type_no");

				CusInfo cusInfo = new CusInfo(res.getString("cus_info_id"),
						res.getString("cert_type"),
						res.getString("cert_number"), res.getString("name"),
						res.getString("phone"), res.getString("address"),
						res.getString("sex"), res.getString("comment"));
				CusTypeDao dao = new CusTypeDao();
				cusInfo.setCusType(dao.findById(cusTypeNo));
				return cusInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// 修改
	public int update(CusInfo cusInfo, int cusTypeNo) {
		con = DBConnection.getConnection();
		String sql = "update cus_info set cus_info_id = ?,cert_type = ?,cert_number = ?,name = ?,phone = ?,address = ?,sex = ?,cus_type_no = ?,comment = ? where cus_info_id = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, cusInfo.getCusInfoId());
			pre.setString(2, cusInfo.getCertType());
			pre.setString(3, cusInfo.getCertNumber());
			pre.setString(4, cusInfo.getName());
			pre.setString(5, cusInfo.getPhone());
			pre.setString(6, cusInfo.getAddresss());
			pre.setString(7, cusInfo.getSex());
			pre.setInt(8, cusTypeNo);
			pre.setString(9, cusInfo.getComment());
			pre.setString(1, cusInfo.getCusInfoId());
			int i = pre.executeUpdate();
			if (i > 0) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 1;
	}
}
