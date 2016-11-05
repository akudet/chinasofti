package tp1.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tp1.model.dao.AbstractDAO;
import tp1.model.dao.impl.jdbc.db.DBConnection;
import tp1.model.vo.cus.Vip;
import tp1.model.vo.room.Room;
import tp1.model.vo.room.RoomType;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomDAO extends AbstractDAO<Room>{
	
	private static final int DATE_PAGE=5;
	@Override
	
	public List<Room> findAll(int pageNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		List<Room> list = new ArrayList<Room>();
		String sql = "select * from room limit ?,?";
	
	try {
		con = DBConnection.getConnection();
		pre = con.prepareStatement(sql);
		pre.setInt(1, (pageNo - 1) * DATE_PAGE);
		pre.setInt(2, DATE_PAGE);
		res = pre.executeQuery();
		while(res.next()){
			Room room = new Room();
			RoomTypeDAO roomTypeDao = new RoomTypeDAO();
			RoomType roomType = roomTypeDao.findById(res.getInt("room_type_no"));
			room.setRoomId(res.getString(1));
			room.setRoomType(roomType);
			room.setFloor(res.getString(3));
			room.setPhone(res.getString(4));
			room.setStatus(res.getInt(5));
			room.setComment(res.getString(6));
			list.add(room);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return list;
	}

	@Override
	public int getTotalPage() {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		int count = 0;
		String sql = "select count(*) from room";
		
		try {
			con = DBConnection.getConnection();
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = (int) Math.ceil((count + 1.0 - 1.0) / DATE_PAGE);
		return count;
	}

	Connection con = DBConnection.getConnection();

	// 添加房间
	public int add(Room room) {
		String sql = "insert into room values(?,?,?,?,?,?)";
		try {
			int roomTypeNo = room.getRoomType().getRoomTypeNo();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoomId());
			ps.setInt(2, roomTypeNo);
			ps.setString(3, room.getFloor());
			ps.setString(4, room.getPhone());
			ps.setInt(5, room.getStatus());
			ps.setString(6, room.getComment());
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

	// 删除所有
	public int deleteAll() {
		String sql = "delete from room";

		return 0;
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
				// 0代表成功
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
				int roomTypeNo = rs.getInt("room_type_no");
				Room room = new Room(rs.getString("room_id"),
						rs.getString("floor"), rs.getString("phone"),
						rs.getInt("status"), rs.getString("comment"));
				RoomTypeDAO roomTypeDao = new RoomTypeDAO();
				room.setRoomType(roomTypeDao.findById(roomTypeNo));
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
		ResultSet rs = null;
		String sql = "select * from room where room_id=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roomid);
			rs = pre.executeQuery();
			if (rs.next()) {
				int roomTypeNo = rs.getInt("room_type_no");
				Room room = new Room(rs.getString("room_id"),
						rs.getString("floor"), rs.getString("phone"),
						rs.getInt("status"), rs.getString("comment"));
				RoomTypeDAO roomTypeDao = new RoomTypeDAO();
				room.setRoomType(roomTypeDao.findById(roomTypeNo));
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
		String sql = "update room set room_type_no = ?,floor = ?,phone = ?,status = ?,comment=? where room_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			int roomTypeNo = room.getRoomType().getRoomTypeNo();
			ps.setInt(1, roomTypeNo);
			ps.setString(2, room.getFloor());
			ps.setString(3, room.getPhone());
			ps.setInt(4, room.getStatus());
			ps.setString(5, room.getComment());
			ps.setString(6, room.getRoomId());
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

	public List<Room> findByRoomTypeNo(String roomTypeNo) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		
		RoomTypeDAO roomTypeDao = new RoomTypeDAO();
		RoomType roomType = roomTypeDao.findById(Integer.parseInt(roomTypeNo));
		
		List<Room> rooms = new ArrayList<Room>();
		String sql = "select * from room where room_type_no=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(roomTypeNo));
			System.out.println(pre);
			rs = pre.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.map(rs);
				room.setRoomType(roomType);
				rooms.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;

	}
	
	public List<Room> findFreeRoom(String roomTypeNo) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		
		RoomTypeDAO roomTypeDao = new RoomTypeDAO();
		RoomType roomType = roomTypeDao.findById(Integer.parseInt(roomTypeNo));
		
		List<Room> rooms = new ArrayList<Room>();
		String sql = "select * from room where room_type_no=? and status=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(roomTypeNo));
			pre.setInt(2, Room.ROOM_STATUS_FREE);
			System.out.println(pre);
			rs = pre.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.map(rs);
				room.setRoomType(roomType);
				rooms.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;

	}
	
	// 根据房间类型查询所有房间
	  public List<Room> findAllByTypeNo(String roomypeNo) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<Room> list = new ArrayList<Room>();
		String sql = "select * from room where room_type_no=?";
		try {
				pre = con.prepareStatement(sql);
				pre.setString(1, roomypeNo);//TODO : should be int
				rs = pre.executeQuery();
				while (rs.next()) {
					int roomType = rs.getInt("room_type_no");
					Room room = new Room();
					room.map(rs);
					RoomTypeDAO roomTypeDao = new RoomTypeDAO();
					room.setRoomType(roomTypeDao.findById(roomType));
					list.add(room);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}

	public List<Room> findByRoomStatus(int status) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		
		List<Room> rooms = new ArrayList<Room>();
		String sql = "select * from room where status=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, status);
			System.out.println(pre);
			rs = pre.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.map(rs);
				room.setRoomType(new RoomTypeDAO().findById(rs.getInt("room_type_no")));
				rooms.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;

	}
	
}
