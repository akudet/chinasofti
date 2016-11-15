package team4.proj1.model.vo.room;

import java.sql.ResultSet;
import java.sql.SQLException;

import team4.proj1.model.vo.ValueObject;

/**
 * 
 * @author 张科林
 * 
 */
public class RoomType extends ValueObject {

	@Override
	public String toString() {
		return "RoomType [roomTypeNo=" + roomTypeNo + ", roomTypeDesc="
				+ roomTypeDesc + ", beds=" + beds + ", price=" + price
				+ ", isHourRoom=" + isHourRoom + ", hourRoomPrice="
				+ hourRoomPrice + ", comment=" + comment + "]";
	}

	protected int roomTypeNo;
	protected String roomTypeDesc;
	protected int beds;
	protected Float price;
	protected int isHourRoom;
	protected Float hourRoomPrice;
	protected String comment;
	
	public static final int HOUR_ROOM = 0;
	public static final int NORMAL_ROOM = 1;

	public void setHourRoom() {
		isHourRoom = HOUR_ROOM;
	}
	
	public boolean isHourRoom() {
		return isHourRoom == HOUR_ROOM ;
	}
	
	public void setNormalRoom() {
		isHourRoom = NORMAL_ROOM;
	}
	
	public boolean isNormalRoom() {
		return isHourRoom == NORMAL_ROOM;
	}
	
	public RoomType() {
		super();
	}

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

	public int getIsHourRoom() {
		return isHourRoom;
	}

	public Float getPrice() {
		return price;
	}

	public String getRoomTypeDesc() {
		return roomTypeDesc;
	}

	public int getRoomTypeNo() {
		return roomTypeNo;
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		this.beds = rs.getInt("beds");
		this.comment = rs.getString("comment");
		this.hourRoomPrice = rs.getFloat("hourRoomPrice");
		this.isHourRoom = rs.getInt("isHourRoom");
		this.price = rs.getFloat("price");
		this.roomTypeDesc = rs.getString("room_type_desc");
		this.roomTypeNo = rs.getInt("room_type_no");
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

	public void setIsHourRoom(int isHourRoom) {
		this.isHourRoom = isHourRoom;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setRoomTypeDesc(String roomTypeDesc) {
		this.roomTypeDesc = roomTypeDesc;
	}

	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}

}
