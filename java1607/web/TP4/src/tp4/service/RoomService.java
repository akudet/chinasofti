package tp4.service;

import java.util.List;

import tp4.model.vo.Room;

public class RoomService {

	// 参考 2.9 房间信息管理

	public static final int ERR_ROOM_INUSE = 1;

	public int add(String roomId, String roomTypeDesc, String floor,
			String phone, String status, String comment) {
		return -1;
	}

	// 返回 ERR_ROOM_INUSE 表示房间被占用, 0 表示成功
	public int deleteById(String roomId) {
		return -1;
	}

	public List<Room> findByType() {
		return null;
	}

	public int updateById(String roomId, String roomTypeDesc, String floor,
			String phone, String status, String comment) {
		return -1;
	}

}
