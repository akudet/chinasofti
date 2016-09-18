package tp4.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * 
 * @author 张科林
 * 
 */
public class Room extends VirtualObject {

	protected String roomId;
	protected RoomType roomType;
	protected String floor;
	protected String phone;
	protected int status;
	protected String comment;

	// 0位可用 1位停用
	public static final int ROOM_STATUS_INUSE = 1;
	public static final int ROOM_STATUS_FREE = 0;
	public static final int ROOM_STATUS_RESERVED = 2;
	public static final int ROOM_STATUS_BLOCKED = 3;

	public void setStatusFree() {
		this.status = 0;
	}
	
	public boolean isFree() {
		return this.status == ROOM_STATUS_FREE;
	}
	
	public void setStatusInuse() {
		this.status = ROOM_STATUS_INUSE;
	}
	
	public boolean isInuse() {
		return this.status == ROOM_STATUS_INUSE;
	}
	
	public void setStatusReserved() {
		this.status = ROOM_STATUS_RESERVED;
	}
	
	public boolean isReserved() {
		return this.status == ROOM_STATUS_RESERVED;
	}
	
	//停用
	public void setStatusBlocked() {
		this.status = ROOM_STATUS_BLOCKED;
	}
	
	public boolean isBlocked() {
		return this.status == ROOM_STATUS_BLOCKED;
	}

	public Room() {
		super();
	}

	public Room(String floor, String phone, int status, String comment) {
		super();
		this.roomId = UUID.randomUUID().toString().replace("-", "");
		this.floor = floor;
		this.phone = phone;
		this.status = status;
		this.comment = comment;
	}

	public Room(String roomId, String floor, String phone, int status,
			String comment) {
		super();
		this.roomId = roomId;
		this.floor = floor;
		this.phone = phone;
		this.status = status;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public String getFloor() {
		return floor;
	}

	public String getPhone() {
		return phone;
	}

	public String getRoomId() {
		return roomId;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public String getRoomTypeDesc() {
		return roomType.getRoomTypeDesc();
	}

	public int getRoomTypeNo() {
		return roomType.getRoomTypeNo();
	}

	public int getStatus() {
		return status;
	}

	public String getStatusDesc() {
		return getMsg(status);
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		this.comment = rs.getString("comment");
		this.floor = rs.getString("floor");
		this.phone = rs.getString("phone");
		this.roomId = rs.getString("room_id");
		this.status = rs.getInt("status");
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
