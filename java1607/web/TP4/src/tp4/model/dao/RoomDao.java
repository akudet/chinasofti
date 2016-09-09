package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp4.model.db.DBConnection;
import tp4.model.vo.Room;

public class RoomDao {

	
	Connection con = DBConnection.getConnection();
	public ArrayList<Room> findRoomById(String id) {
		
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
	public int deleteRoombById(String id) {
		return 0;
	}
	
	public int updateRoom(Room room) {
		return 0;
	}
	
	public int addRoom(Room room) {
		
		return 0;
	}
}
