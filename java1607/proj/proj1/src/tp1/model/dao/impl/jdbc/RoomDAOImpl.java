package tp1.model.dao.impl.jdbc;

import java.util.List;

import tp1.model.dao.impl.jdbc.abst.JDBCAbstractDAO;
import tp1.model.dao.impl.jdbc.mapper.RoomMapper;
import tp1.model.dao.include.room.RoomDAO;
import tp1.model.vo.room.Room;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomDAOImpl extends JDBCAbstractDAO<Room> implements RoomDAO {

	public RoomDAOImpl() {
		super(new RoomMapper(), "room");
	}

	// 添加房间
	@Override
	public int add(Room room) {
		String sql = "insert into room values(?,?,?,?,?,?)";
		int roomTypeNo = room.getRoomType().getRoomTypeNo();
		return update(sql, room.getRoomId(), roomTypeNo, room.getFloor(),
				room.getPhone(), room.getStatus(), room.getComment());
	}

	// 删除房间
	@Override
	public int deleteByRoomId(String roomId) {
		String sql = "delete from room where room_id =?";
		return update(sql, roomId);
	}

	@Override
	public List<Room> findAllByRoomStatus(int status) {
		String sql = "select * from room where status=?";
		return findAll(sql, status);
	}

	@Override
	public List<Room> findAllByRoomTypeNo(String roomTypeNo) {
		String sql = "select * from room where room_type_no=?";
		return findAll(sql, roomTypeNo);
	}

	@Override
	public List<Room> findAllFreeRoomByRoomTypeNo(String roomTypeNo) {
		String sql = "select * from room where room_type_no=? and status=?";
		return findAll(sql, roomTypeNo, Room.ROOM_STATUS_FREE);
	}

	// 查询单个房间信息
	@Override
	public Room findOneByRoomId(String roomId) {
		String sql = "select * from room where room_id=?";
		return findOne(sql, roomId);
	}

	// 修改房间信息
	@Override
	public int update(Room room) {
		String sql = "update room set room_type_no = ?,floor = ?,phone = ?,status = ?,comment=? where room_id = ?";
		int roomTypeNo = room.getRoomType().getRoomTypeNo();
		return update(sql, roomTypeNo, room.getFloor(), room.getPhone(),
				room.getStatus(), room.getComment(), room.getRoomId());
	}

}
