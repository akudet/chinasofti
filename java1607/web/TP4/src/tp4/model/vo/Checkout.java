package tp4.model.vo;

/**
 * 
 * @author 田霞光
 * 
 */
public class Checkout {
	protected String checkoutId;
	protected float checkoutAmount;
	protected String checkoutTime;
	protected String comment;
	protected Checkin checkin;
	public Checkout() {
		super();
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
				+ ", comment=" + comment + "]";
	}

}
