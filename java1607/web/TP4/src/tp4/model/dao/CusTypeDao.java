package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp4.model.db.DBConnection;
import tp4.model.vo.CusType;

/**
 *
 * @author 项双江
 *
 */
public class CusTypeDao {
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res;

	// 全查询
	public ArrayList<CusType> findAll() {
		con = DBConnection.getConnection();
		String sql = "select * from cus_type";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<CusType> list = new ArrayList<CusType>();
			while (res.next()) {
				CusType cusType = new CusType(res.getInt("cus_type_no"),
						res.getString("cus_type_desc"), res.getInt("discount"));
				list.add(cusType);
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
	
	//单查询
	public CusType findById(int cusTypeNo) {
		con = DBConnection.getConnection();
		String sql = "select * from cus_type where cus_type_no = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, cusTypeNo);
			res = pre.executeQuery();
			if (res.next()) {
				CusType cusType = new CusType(res.getInt("cus_type_no"),
						res.getString("cus_type_desc"), res.getInt("discount"));
				return cusType;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre, res);
		}
		return null;
	}
	
	//增加
	public int add(CusType cusType){
		con = DBConnection.getConnection();
		String sql = "insert into cus_type values(?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, cusType.getCusTypeNo());
			pre.setString(2, cusType.getCusTypeDesc());
			pre.setInt(3, cusType.getDiscount());
			int i = pre.executeUpdate();
			if (i>0) {
				return i;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre);
		}
		return 0;
	}
	
	//删除
	public int deleteById(int cusTypeNo){
		con = DBConnection.getConnection();
		String sql = "delete from cus_type where cus_type_no = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, cusTypeNo);
			int i = pre.executeUpdate();
			if (i>0) {
				return i;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre);
		}
		return 0;
		
	}
	
	//修改
	public boolean update(int cusTypeNo,String cusTypeDesc,int discount){
		con = DBConnection.getConnection();
		String sql = "update cus_type set cus_type_no = ?,cus_type_desc = ?,discount = ? where cus_type_no = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, cusTypeNo);
			pre.setString(2, cusTypeDesc);
			pre.setInt(3, discount);
			pre.setInt(4, cusTypeNo);
			int i = pre.executeUpdate();
			if (i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre);
		}
		return false;
	}
}
