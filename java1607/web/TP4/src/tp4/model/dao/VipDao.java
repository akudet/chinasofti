package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import tp4.model.db.DBConnection;
import tp4.model.vo.CusInfo;
import tp4.model.vo.Vip;

/**
 * 
 * @author 马厦伟
 *
 */
public class VipDao {
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	
//	添加数据
	public int add(Vip vip){
		con = DBConnection.getConnection();
		String sql = "insert into vip values(?,?)";
		try {
			pre = con.prepareStatement(sql);
			String udi = UUID.randomUUID().toString();
			
			pre.setInt(1,vip.getVipNumber());
			pre.setString(2,vip.getCusInformation().getCusInfoId());
			
			int i= pre.executeUpdate();
			if(i>0){
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre, res);
		}
	return 0;
	}


//查询数据
	public ArrayList<Vip> findAll(){
		
		con = DBConnection.getConnection();
		String sql = "select * from vip";
		try {
			pre= con.prepareStatement(sql);
			res= pre.executeQuery();
			ArrayList<Vip> list = new ArrayList<Vip>();
			while(res.next()){
				CusInfoDao dao = new CusInfoDao();
				CusInfo cusInfo = dao.queryCusInfoByID(res.getString("cus_info_id"));
				Vip vip = new Vip(res.getInt("vip_no"),cusInfo);
				list.add(vip);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre, res);
		}
		return null;
	}
//	删除数据
	public Vip delete(int vipNumber){
		con=DBConnection.getConnection();
		String sql = "select * from vip where vip_no= ?";
		try {
			pre= con.prepareStatement(sql);
			pre.setInt(1, vipNumber);
			res=pre.executeQuery();
			if(res.next()){
				CusInfoDao dao = new CusInfoDao();
				CusInfo cusInfo= dao.queryCusInfoByID(res.getString("cus_info_id"));
				Vip vip = new Vip(res.getInt("vip_no"),cusInfo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
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
				return vip;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
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
			pre.setInt(1, vipNumber.getVipNumber());
			pre.setString(2, vipNumber.getCusInformation().getCusInfoId());

			int i = pre.executeUpdate();
			if (i > 0) {
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
	
	
}
