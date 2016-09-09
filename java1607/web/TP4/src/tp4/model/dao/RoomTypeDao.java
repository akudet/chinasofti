package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp4.model.db.DBConnection;
import tp4.model.vo.RoomType;

public class RoomTypeDao {

	Connection con = DBConnection.getConnection();
	public ArrayList<RoomType> findAllRoomType() {
		String sql = "select * from room_type";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<RoomType> list = new ArrayList<RoomType>();
			while(rs.next()){
				RoomType roomType = new RoomType(
						rs.getInt("room_type_no"),
						rs.getString("room_type_desc"),
						rs.getInt("beds"),
						rs.getFloat("price"),
						rs.getInt("isHourRoom"),
						rs.getFloat("hourRoomPrice"),
						rs.getString("comment"));
				list.add(roomType);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	// 0 
	public int updateRoomType(RoomType roomtype) {
		String sql = "delete from room_type where room_type_no=?"; 
		
		return 1;
	}
}
