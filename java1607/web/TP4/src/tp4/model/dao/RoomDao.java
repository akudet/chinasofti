package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp4.model.db.DBConnection;
import tp4.model.vo.Checkout;
import tp4.model.vo.Room;

/**
 *
 * @author 张科林
 *
 */
public class RoomDao {

	
	Connection con = DBConnection.getConnection();
	//
	public ArrayList<Room> findAllRoom() {
		
		String sql = "select * from room";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Room> list = new ArrayList<Room>();
			while (rs.next()) {
				Room room = new Room(rs.getString("room_id"), 
						rs.getString("floor"), 
						rs.getString("phone"), 
						rs.getInt("status"), 
						rs.getString("comment")); 
				list.add(room);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//
	public Room findRoomById(String roomid){
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res =null;
		String sql="select * from room where room_id=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roomid);
		    res = pre.executeQuery();
			if(res.next())
			{
				Room room = new Room(res.getString("room_id"), 
						res.getString("floor"), 
						res.getString("phone"), 
						res.getInt("status"), 
						res.getString("comment")); 
				return room;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	//删除房间
	public int deleteRoombById(String roomId) {
		String sql = "delete from room_type where room_id =?"; 
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,roomId);
			int flag = ps.executeUpdate();
			if(flag>0){
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//
	public int updateRoom(Room room) {
		return 0;
	}
	//
	public int addRoom(Room room) {
		
		return 0;
	}
}
