package team4.proj1.model.dao.impl.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import team4.proj1.model.dao.impl.jdbc.RoomTypeDAO;
import team4.proj1.model.dao.impl.jdbc.abst.Mapper;
import team4.proj1.model.vo.room.Room;

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
