package team4.proj1.service.impl.admin;

import java.util.List;

import team4.proj1.model.dao.impl.jdbc.RoomDAOImpl;
import team4.proj1.model.dao.impl.jdbc.RoomTypeDAOImpl;
import team4.proj1.model.vo.room.RoomType;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomTypeServiceImpl {

	// 参考 2.8 房间类型管理
	RoomTypeDAOImpl roomTypeDao = new RoomTypeDAOImpl();

	// 添加房间类型
	public int add(int roomTypeNo, String roomTypeDesc, int beds, float price,
			boolean isHourRoom, float hourRoomPrice, String comment) {
		RoomType roomType = new RoomType(roomTypeNo, roomTypeDesc, beds, price,
				0, hourRoomPrice, comment);
		
		if (isHourRoom) {
			roomType.setHourRoom();
		} else {
			roomType.setNormalRoom();
		}

		return roomTypeDao.add(roomType);

	}

	// 删除房间类型
	public int deleteById(int roomTypeNo) {

		return roomTypeDao.delete(roomTypeNo);
	}

	// 查找房间类型
	public List<RoomType> findAll() {

		return roomTypeDao.findAll();
	}

	// 查找单个房间类型
	public RoomType findById(int roomTypeNo) {

		return roomTypeDao.findById(roomTypeNo);
	}

	// 修改房间类型
	public int updateById(int roomTypeNo, String roomTypeDesc, int beds,
			float price, boolean isHourRoom, String hourRoomPrice, String comment) {

		RoomType roomType = roomTypeDao.findById(roomTypeNo);
		roomType.setRoomTypeNo(roomTypeNo);
		roomType.setRoomTypeDesc(roomTypeDesc);
		roomType.setBeds(beds);
		roomType.setPrice(price);

		if (isHourRoom) {
			roomType.setHourRoom();
			roomType.setHourRoomPrice(Float.parseFloat(hourRoomPrice));
		} else {
			roomType.setNormalRoom();
		}
		
		
		roomType.setComment(comment);

		return roomTypeDao.update(roomType);
	}
}
