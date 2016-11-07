package tp1.service;

import java.util.ArrayList;
import java.util.List;

import tp1.model.dao.impl.jdbc.RoomDAOImpl;
import tp1.model.dao.impl.jdbc.RoomTypeDAO;
import tp1.model.vo.room.Room;
import tp1.model.vo.room.RoomType;

/**
 * 
 * @author 巫金桐
 * 
 */
public class RoomService {

	// 参考 2.9 房间信息管理

	private RoomDAOImpl mRoomDao;
	private RoomTypeDAO mRoomTypeDao;

	public static final int ERR_ROOM_INUSE = 1;

	public static final int ERR_WRONG_ROOM_TYPE = 2;

	public static final int ERR_WRONG_ROOM_ID = 0;

	public static final int ERR_UPDATE_FAILED = 3;

	public RoomService() {
		super();
		mRoomDao = new RoomDAOImpl();
		mRoomTypeDao = new RoomTypeDAO();
	}

	// 添加
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
	// 删除
	public int deleteById(String roomId) {
		// TODO : thread safety
		Room room = mRoomDao.findOneByRoomId(roomId);
		// TODO : remove magic number
		if (room.getStatus() == 1) {
			return ERR_ROOM_INUSE;
		}
		return mRoomDao.deleteByRoomId(roomId);
	}

	//根据房间类型查找
	public List<Room> findAllByTypeNo(String roomtypeNo)
	{
		return mRoomDao.findAllByRoomTypeNo(roomtypeNo);
	}

	// 修改
	public int updateById(String roomId, int roomTypeId, String floor,
			String phone, int status, String comment) {
		Room room = mRoomDao.findOneByRoomId(roomId);
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

	public List<Room> findAll() {
		return mRoomDao.findAll();
	}

	public Room findById(String roomId) {
		return mRoomDao.findOneByRoomId(roomId);
	}

	public List<Room> findAllFreeRooms() {
		List<Room> rooms = mRoomDao.findAllByRoomStatus(Room.ROOM_STATUS_FREE);
		return rooms;
	}

	public List<Room> findPage(String pageNo) {
		// TODO Auto-generated method stub
		return mRoomDao.findAll(Integer.parseInt(pageNo));
	}

	public int getTotalPages() {
		return mRoomDao.getTotalPage();
	}

}
