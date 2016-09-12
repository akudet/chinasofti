package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import tp4.model.db.DBConnection;
import tp4.model.vo.Room;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomDao {

	Connection con = DBConnection.getConnection();

	// 添加房间
	public int add(Room room) {
		String sql = "insert into room values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString();
			ps.setString(1, uuid);
			ps.setString(2, room.getFloor());
			ps.setString(3, room.getPhone());
			ps.setInt(4, room.getStatus());
			ps.setString(5, room.getComment());
			ps.setString(6, room.getRoomId());
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}

	// 删除房间
	public int deleteById(String roomId) {
		String sql = "delete from room where room_id =?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, roomId);
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	// 查询所有房间信息
	public ArrayList<Room> findAll() {

		String sql = "select * from room";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Room> list = new ArrayList<Room>();
			while (rs.next()) {
				Room room = new Room(rs.getString("room_id"),
						rs.getString("floor"), rs.getString("phone"),
						rs.getInt("status"), rs.getString("comment"));
				list.add(room);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 查询单个房间信息
	public Room findById(String roomid) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from room where room_id=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roomid);
			res = pre.executeQuery();
			if (res.next()) {
				Room room = new Room(res.getString("room_id"),
						res.getString("floor"), res.getString("phone"),
						res.getInt("status"), res.getString("comment"));
				return room;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// 修改房间信息
	public int update(Room room) {
		String sql = "update room set floor = ?,phone = ?,status = ?,comment=? where room_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, room.getFloor());
			ps.setString(2, room.getPhone());
			ps.setInt(3, room.getStatus());
			ps.setString(4, room.getComment());
			ps.setString(5, room.getRoomId());
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}
}
