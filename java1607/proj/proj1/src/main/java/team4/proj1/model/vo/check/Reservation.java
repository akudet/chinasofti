package team4.proj1.model.vo.check;

import java.sql.ResultSet;
import java.sql.SQLException;

import team4.proj1.model.vo.ValueObject;
import team4.proj1.model.vo.room.Room;

/**
 * 
 * @author 范中兴
 * 
 */
public class Reservation extends ValueObject {

	protected String reservationId;
	protected String name;
	protected String phone;
	protected String arriveTime;
	protected String reserveTime;
	protected String reservationTime;
	protected String comment;
	protected Room room;

	public Reservation() {
		super();
		this.reservationId = randomId();
	}

	public Reservation(String reservationId, String name, String phone,
			String arriveTime, String reserveTime, String reservationTime,
			String comment) {
		super();
		this.reservationId = reservationId;
		this.name = name;
		this.phone = phone;
		this.arriveTime = arriveTime;
		this.reserveTime = reserveTime;
		this.reservationTime = reservationTime;
		this.comment = comment;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public String getComment() {
		return comment;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getReservationId() {
		return reservationId;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	@Override
	public String toString() {
		return "UserDao [reservationId=" + reservationId + ", name=" + name
				+ ", phone=" + phone + ", arriveTime=" + arriveTime
				+ ",reserveTime=" + reserveTime + ",reservationTime="
				+ reservationTime + ",comment=" + comment + "]";
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		reservationId=rs.getString("reservation_id");
		name=rs.getString("name");
		phone=rs.getString("phone");
		arriveTime=parseDateTime(rs.getTimestamp("arrive_time"));
		reserveTime=parseDateTime(rs.getTimestamp("reserve_time"));
		reservationTime=parseDateTime(rs.getTimestamp("reservation_time"));
		comment=rs.getString("comment");
		
	}

}
