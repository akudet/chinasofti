package tp4.model.vo;

/**
 *
 * @author 张科林
 *
 */
public class Room {
	protected String roomId;
	protected RoomType roomTypeNo;
	protected String floor;
	protected String phone;
	protected int status;
	protected String comment;
	
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public RoomType getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(RoomType roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Room(String roomId, String floor, String phone,
			int status, String comment) {
		super();
		this.roomId = roomId;
		this.floor = floor;
		this.phone = phone;
		this.status = status;
		this.comment = comment;
	}
	
	

	
	
}
