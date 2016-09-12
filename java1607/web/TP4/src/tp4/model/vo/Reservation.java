package tp4.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import tp4.model.db.DBConnection;

/**
 * 
 * @author 范中兴
 *
 */
public class Reservation {
	protected String reservationId;
	protected String name;
	protected String phone;
	protected String arriveTime;
	protected String reserveTime;
	protected String reservationTime;
	protected String comment;
	public Reservation() {

	}

	public Reservation(String reservationId, String name, String phone, String arriveTime,String reserveTime,String reservationTime,String comment) {
		super();
		this.reservationId = reservationId;
		this.name = name;
		this.phone = phone;
		this.arriveTime = arriveTime;
		this.reserveTime=reserveTime;
		this.reservationTime=reservationTime;
		this.comment=comment;
	}

	

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "UserDao [reservationId=" + reservationId + ", name=" + name
				+ ", phone=" + phone + ", arriveTime=" + arriveTime + ",reserveTime="+reserveTime+",reservationTime="+reservationTime+",comment="+comment+"]";
	}

}
