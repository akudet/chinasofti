package tp1.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tp1.model.dao.impl.jdbc.abst.db.DBConnection;
import tp1.model.vo.room.RoomType;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomTypeDAO {

	Connection con = DBConnection.getConnection();

	// 添加房间类型
	public int add(RoomType roomType) {
		String sql = "insert into room_type values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roomType.getRoomTypeNo());
			ps.setString(2, roomType.getRoomTypeDesc());
			ps.setInt(3, roomType.getBeds());
			ps.setFloat(4, roomType.getPrice());
			ps.setInt(5, roomType.getIsHourRoom());
			ps.setFloat(6, roomType.getHourRoomPrice());
			ps.setString(7, roomType.getComment());

			int flag = ps.executeUpdate();
			if (flag > 0) {
				return 0;
				// 0代表成功
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	// 删除房间类型
	public int delete(int roomTypeNo) {
		String sql = "delete from room_type where room_type_no=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roomTypeNo);
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return 0;
				// 0代表成功
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}

	// 查询所有房间类型
	public ArrayList<RoomType> findAll() {
		String sql = "select * from room_type";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<RoomType> list = new ArrayList<RoomType>();
			while (rs.next()) {
				RoomType roomType = new RoomType(rs.getInt("room_type_no"),
						rs.getString("room_type_desc"), rs.getInt("beds"),
						rs.getFloat("price"), rs.getInt("isHourRoom"),
						rs.getFloat("hourRoomPrice"), rs.getString("comment"));
				list.add(roomType);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// 查询单个房间类型
	public RoomType findById(int roomTypeNo) {
		String sql = "select * from room_type where room_type_no=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roomTypeNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RoomType roomType = new RoomType(rs.getInt("room_type_no"),
						rs.getString("room_type_desc"), rs.getInt("beds"),
						rs.getFloat("price"), rs.getInt("isHourRoom"),
						rs.getFloat("hourRoomPrice"), rs.getString("comment"));
				return roomType;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 修改房间类型
	public int update(RoomType roomType) {
		String sql = "update room_type set room_type_desc=?,beds=?,price=?,isHourRoom=?,hourRoomPrice=?,comment=? where room_type_no=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, roomType.getRoomTypeDesc());
			ps.setInt(2, roomType.getBeds());
			ps.setFloat(3, roomType.getPrice());
			ps.setInt(4, roomType.getIsHourRoom());
			ps.setFloat(5, roomType.getHourRoomPrice());
			ps.setString(6, roomType.getComment());
			ps.setInt(7, roomType.getRoomTypeNo());

			int flag = ps.executeUpdate();
			if (flag > 0) {
				return 0;
				// 0代表成功
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}
}
