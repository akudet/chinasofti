package tp4.model.vo;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomType {

	protected int roomTypeNo;
	protected String roomTypeDesc;
	protected int beds;
	protected Float price;
	protected int isHourRoom;
	protected Float hourRoomPrice;
	protected String comment;

	public RoomType(int roomTypeNo, String roomTypeDesc, int beds, Float price,
			int isHourRoom, Float hourRoomPrice, String comment) {
		super();
		this.roomTypeNo = roomTypeNo;
		this.roomTypeDesc = roomTypeDesc;
		this.beds = beds;
		this.price = price;
		this.isHourRoom = isHourRoom;
		this.hourRoomPrice = hourRoomPrice;
		this.comment = comment;
	}

	public int getBeds() {
		return beds;
	}

	public String getComment() {
		return comment;
	}

	public Float getHourRoomPrice() {
		return hourRoomPrice;
	}

	public int getIsHourroom() {
		return isHourRoom;
	}

	public Float getPrice() {
		return price;
	}

	public String getRoomTypedesc() {
		return roomTypeDesc;
	}

	public int getRoomTypeNo() {
		return roomTypeNo;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setHourRoomPrice(Float hourRoomPrice) {
		this.hourRoomPrice = hourRoomPrice;
	}

	public void setIsHourroom(int isHourRoom) {
		this.isHourRoom = isHourRoom;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setRoomTypedesc(String roomTypeDesc) {
		this.roomTypeDesc = roomTypeDesc;
	}

	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}

}
