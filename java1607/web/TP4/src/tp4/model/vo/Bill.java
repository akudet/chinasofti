package tp4.model.vo;

/**
 *
 * @author 田霞光
 *
 */
public class Bill {
	public Bill(float bill_amount, String comment) {
		super();
		this.billAmount = bill_amount;
		this.comment = comment;
	}
	public Bill() {
		super();
	}
	public Bill(String bill_id, float bill_amount, String bill_time,
			String comment) {
		super();
		this.billId = bill_id;
		this.billAmount = bill_amount;
		this.billTime = bill_time;
		this.comment = comment;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	public String getBillTime() {
		return billTime;
	}
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	protected String billId;
	protected float billAmount;
	protected String billTime;
	protected String comment;

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
