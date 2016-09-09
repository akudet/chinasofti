package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



import tp4.model.db.DBConnection;


import tp4.model.vo.Checkin;
import tp4.model.vo.CusInfo;
import tp4.model.vo.Room;

/**
*
* @author 田霞光
*
*/
public class CheckinDao {
	//checkin表的添加
	public int addCheckin(Checkin checkin) {
		    String cus_info_id = checkin.getCusInfo().getCusInfoId();
		    String room_id = checkin.getRoom().getRoomId();
			Connection con = DBConnection.getConnection();
			String sql="insert into checkin values(?,?,?,?,?,?,?,?)";
			Date date =new Date();
			SimpleDateFormat checkinid = new SimpleDateFormat("yyyyMMddhhmmss");
			SimpleDateFormat checkintime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String now = checkinid.format(date);
			String now1 = checkintime.format(date);
			
			PreparedStatement pre = null;
			
				try {
					pre=con.prepareStatement(sql);
					pre.setString(1, now1);
					pre.setString(2, room_id);
					pre.setString(3, cus_info_id);
					pre.setString(4, now1);
					pre.setString(5,checkin.getCheckinType());
					pre.setFloat(6, checkin.getPrice());
					pre.setInt(7, checkin.getNumOfDays());
					pre.setFloat(8, checkin.getDeposit());
					int i = pre.executeUpdate();
					if(i>0)
					{
						return 1;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   return 0;
		}
	//checkin表的删除
	
		public int deletecheckinById(String checkinid) {

			Connection con = DBConnection.getConnection();
			String sql = "delete from checkin where checkin_id = ?";
			PreparedStatement pre = null;
			try {
				pre =  con.prepareStatement(sql);
				pre.setString(1, checkinid);
				int i = pre.executeUpdate();
				if (i > 0) {
					return i;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return 0;
		}
		//checkin表的全查询
		public ArrayList<Checkin> FincheckinAll() {

			Connection con = DBConnection.getConnection();
			PreparedStatement pre = null;
			ResultSet res = null;
			String sql = "select * from checkin";
			try {
				 pre = con.prepareStatement(sql);
				 res = pre.executeQuery();
				ArrayList<Checkin> list = new ArrayList<Checkin>();
				while (res.next()) {
					CusInfoDao dao = new CusInfoDao();
					RoomDao dao1 = new RoomDao();
					CusInfo cusinfo = dao.queryCusInfoByID(res.getString("cus_info_id"));
					Room room = dao1.findRoomById(res.getString("room_id"));
					Checkin user = new Checkin(res.getString("checkin_id"),room,cusinfo,res.getString("checkin_time"),res.getString("checkin_type"),res.getFloat("price"),res.getInt("num_of_days"),res.getFloat("deposit"));
					list.add(user);
				}

				return list;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} 
		//checkin表单查询
		public Checkin findBillById(String checkin){
			Connection con = DBConnection.getConnection();
			PreparedStatement pre = null;
			ResultSet res =null;
			String sql="select * from checkin where checkin_id=?";
			try {
				pre = con.prepareStatement(sql);
				pre.setString(1, checkin);
			    res = pre.executeQuery();
				if(res.next())
				{
					CusInfoDao dao = new CusInfoDao();
					RoomDao dao1 = new RoomDao();
					CusInfo cusinfo = dao.queryCusInfoByID(res.getString("cus_info_id"));
					Room room = dao1.findRoomById(res.getString("room_id"));
					Checkin user = new Checkin(res.getString("checkin_id"),room,cusinfo,res.getString("checkin_time"),res.getString("checkin_type"),res.getFloat("price"),res.getInt("num_of_days"),res.getFloat("deposit"));
					
					return user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		//checkin修改
		public int updateCheckin(Checkin checkin)
		{
			Connection con = DBConnection.getConnection();
			String sql ="update checkin set checkin_id=?, room_id=?,cus_info_id=？,checkin_time=?,checkin_type=?,price=?,num_of_days=?,deposit=? where checkin_id= ? ";
			PreparedStatement pre = null;
			try {
				pre =con.prepareStatement(sql);
				pre.setString(1, checkin.getCheckinId());
				pre.setString(2,checkin.getRoom().getRoomId());
				
				pre.setString(4, checkin.getCusInfo().getCusInfoId());
				pre.setString(5, checkin.getCheckinTime());
				pre.setString(6, checkin.getCheckinType());
				pre.setFloat(3, checkin.getPrice());
				pre.setInt(7, checkin.getNumOfDays());
				pre.setFloat(8, checkin.getDeposit());
				int i = pre.executeUpdate();
				if(i>0)
				{
					return 1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		

}
