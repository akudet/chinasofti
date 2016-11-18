package team4.proj1.model.vo.check;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import team4.proj1.model.vo.ValueObject;

/**
 * 
 * @author 田霞光
 * 
 */
@Entity
@Table(name = "checkout")
public class Checkout extends ValueObject {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "checkout_id")
	protected String checkoutId;
	@Column(name = "checkout_amount")
	protected float checkoutAmount;
	@Column(name = "checkout_time")
	protected String checkoutTime;
	@Column(name = "comment")
	protected String comment;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "checkin_id")
	protected Checkin checkin;

	public Checkout() {
		super();
	}

	public String getRoomTypeDesc() {
		return checkin.getRoomTypeDesc();
	}

	public String getRoomId() {
		return checkin.getRoomId();
	}

	public int getCheckinType() {
		return checkin.getCheckinType();
	}

	public String getCheckinTypeDesc() {
		return checkin.getCheckinTypeDesc();
	}

	public String getName() {
		return checkin.getName();
	}

	public Checkout(float checkouAmount, String comment) {
		super();
		this.checkoutAmount = checkouAmount;
		this.comment = comment;
	}

	public Checkout(String checkoutId, float checkoutAmount,
			String checkoutTime, String comment) {
		super();
		this.checkoutId = checkoutId;
		this.checkoutAmount = checkoutAmount;
		this.checkoutTime = checkoutTime;
		this.comment = comment;
	}

	public Checkout(String checkoutId, float checkoutAmount,
			String checkoutTime, String comment, Checkin checkin) {
		super();
		this.checkoutId = checkoutId;
		this.checkoutAmount = checkoutAmount;
		this.checkoutTime = checkoutTime;
		this.comment = comment;
		this.checkin = checkin;
	}

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

	public float getCheckoutAmount() {
		return checkoutAmount;
	}

	public String getCheckoutId() {
		return checkoutId;
	}

	public String getCheckoutTime() {
		return checkoutTime;
	}

	public String getComment() {
		return comment;
	}

	public void setCheckoutAmount(float checkoutAmount) {
		this.checkoutAmount = checkoutAmount;
	}

	public void setCheckoutId(String checkoutId) {
		this.checkoutId = checkoutId;
	}

	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Checkout [checkoutId=" + checkoutId + ", checkoutAmount="
				+ checkoutAmount + ", checkoutTime=" + checkoutTime
				+ ", comment=" + comment + ", checkin=" + checkin + "]";
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		checkoutId = rs.getString("checkout_id");
		checkoutAmount = rs.getFloat("checkout_amount");
		checkoutTime = rs.getString("checkout_time");
		comment = rs.getString("comment");

	}

}
