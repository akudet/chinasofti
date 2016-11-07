package tp1.model.dao.impl.jdbc.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp1.model.dao.impl.jdbc.RoomTypeDAO;
import tp1.model.dao.impl.jdbc.mapper.Mapper;
import tp1.model.vo.room.Room;

public class RoomMapper implements Mapper<Room> {

	@Override
	public Room map(ResultSet rs) throws SQLException {
		Room room = new Room();
		room.map(rs);
		
		int roomTypeNo = rs.getInt("room_type_no");
		RoomTypeDAO roomTypeDao = new RoomTypeDAO();
		room.setRoomType(roomTypeDao.findById(roomTypeNo));
		return room;
	}

}
