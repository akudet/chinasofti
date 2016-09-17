package tp4.service;

import java.util.List;

import tp4.model.dao.RoomDao;
import tp4.model.dao.RoomTypeDao;
import tp4.model.vo.RoomType;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomTypeService {

	// 参考 2.8 房间类型管理
	RoomTypeDao roomTypeDao = new RoomTypeDao();

	// 添加房间类型
	public int add(int roomTypeNo, String roomTypeDesc, int beds, float price,
			boolean isHourRoom, float hourRoomPrice, String comment) {
		int isHourRoom_t = isHourRoom ? 1 : 0;
		RoomType roomType = new RoomType(roomTypeNo, roomTypeDesc, beds, price,
				isHourRoom_t, hourRoomPrice, comment);

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
			float price, boolean isHourRoom, float hourRoomPrice, String comment) {

		int isHourRoom_t = isHourRoom ? 1 : 0;
		RoomType roomType = roomTypeDao.findById(roomTypeNo);
		roomType.setRoomTypeNo(roomTypeNo);
		roomType.setRoomTypeDesc(roomTypeDesc);
		roomType.setBeds(beds);
		roomType.setPrice(price);
		roomType.setIsHourRoom(isHourRoom_t);
		roomType.setHourRoomPrice(hourRoomPrice);
		roomType.setComment(comment);

		return roomTypeDao.update(roomType);
	}
}
