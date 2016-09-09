package tp4.model.vo;

/**
 *
 * @author 张科林
 *
 */
public class RoomType {

	protected  int roomTypeNo;
	protected  String roomTypeDesc;
	protected  int beds;
	protected  Float price;
	protected  int isHourRoom;
	protected  Float hourRoomPrice;
	protected  String comment;
	public int getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public String getRoomTypedesc() {
		return roomTypeDesc;
	}
	public void setRoomTypedesc(String roomTypeDesc) {
		this.roomTypeDesc = roomTypeDesc;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getIsHourroom() {
		return isHourRoom;
	}
	public void setIsHourroom(int isHourRoom) {
		this.isHourRoom = isHourRoom;
	}
	public Float getHourRoomPrice() {
		return hourRoomPrice;
	}
	public void setHourRoomPrice(Float hourRoomPrice) {
		this.hourRoomPrice = hourRoomPrice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public RoomType(int roomTypeNo, String roomTypeDesc, int beds,
			Float price, int isHourRoom, Float hourRoomPrice, String comment) {
		super();
		this.roomTypeNo = roomTypeNo;
		this.roomTypeDesc = roomTypeDesc;
		this.beds = beds;
		this.price = price;
		this.isHourRoom = isHourRoom;
		this.hourRoomPrice = hourRoomPrice;
		this.comment = comment;
	}
	
	
}
