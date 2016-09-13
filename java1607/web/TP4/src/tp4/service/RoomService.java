package tp4.service;

import java.util.ArrayList;
import java.util.List;

import tp4.model.dao.RoomDao;
import tp4.model.dao.RoomTypeDao;
import tp4.model.vo.Room;
import tp4.model.vo.RoomType;

/**
 * 
 * @author 巫金桐
 * 
 */
public class RoomService {

	// 参考 2.9 房间信息管理

	private RoomDao mRoomDao;
	private RoomTypeDao mRoomTypeDao;

	public static final int ERR_ROOM_INUSE = 1;

	public static final int ERR_WRONG_ROOM_TYPE = 2;

	public static final int ERR_WRONG_ROOM_ID = 0;
	
	public static final int ERR_UPDATE_FAILED = 3;

	public RoomService() {
		super();
		mRoomDao = new RoomDao();
		mRoomTypeDao = new RoomTypeDao();
	}
	//添加
	public int add(String roomId, int roomTypeNo, String floor, String phone,
			int status, String comment) {
		Room room = new Room(roomId, floor, phone, status, comment);
		RoomType roomType = mRoomTypeDao.findById(roomTypeNo);
		if (null == roomType) {
			return -1;
		}
		room.setRoomType(roomType);

		return mRoomDao.add(room);
	}

	// 返回 ERR_ROOM_INUSE 表示房间被占用, 0 表示成功
	//删除
	public int deleteById(String roomId) {
		// TODO : thread safety
		Room room = mRoomDao.findById(roomId);
		// TODO : remove magic number
		if (room.getStatus() == 1) {
			return ERR_ROOM_INUSE;
		}
		return mRoomDao.deleteById(roomId);
	}
	//查找
	public List<Room> findByType(int roomTypeNo) {
		// TODO : performance issue
		List<Room> rooms = mRoomDao.findAll();
		List<Room> results = new ArrayList<Room>();
		for (Room room : rooms) {
			if (room.getRoomType().getRoomTypeNo() == roomTypeNo) {
				results.add(room);
			}
		}
		if (results.size() == 0) {
			return null;
		}
		return results;
	}
	//修改
	public int updateById(String roomId, int roomTypeId, String floor,
			String phone, int status, String comment) {
		Room room = mRoomDao.findById(roomId);
		if (null == room) {
			return ERR_WRONG_ROOM_ID;
		}
		RoomType roomType = mRoomTypeDao.findById(roomTypeId);
		if (null == roomType) {
			return ERR_WRONG_ROOM_TYPE;
		}
		room.setRoomType(roomType);
		room.setFloor(floor);
		room.setPhone(phone);
		room.setStatus(status);
		room.setComment(comment);
		if (0 == mRoomDao.update(room)) {
			return 0;
		}
		return ERR_UPDATE_FAILED;
	}

}
