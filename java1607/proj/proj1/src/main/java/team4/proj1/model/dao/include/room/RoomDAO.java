package team4.proj1.model.dao.include.room;

import java.util.List;

import team4.proj1.model.dao.include.DAO;
import team4.proj1.model.vo.room.Room;

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
