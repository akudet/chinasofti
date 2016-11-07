package tp1.model.dao.room;

import java.util.List;

import tp1.model.dao.DAO;
import tp1.model.vo.room.Room;

/**
 * 
 * @author 巫金桐
 * 
 */
public interface RoomDAO extends DAO<Room> {
	
	public int deleteByRoomId(String roomId);
	
	// 根据房间状态查询所有房间
	public List<Room> findAllByRoomStatus(int status);

	// 根据房间类型查询所有房间
	public List<Room> findAllByRoomTypeNo(String roomTypeNo);

	public List<Room> findAllFreeRoomByRoomTypeNo(String roomTypeNo);

	public Room findOneByRoomId(String roomId);

}
