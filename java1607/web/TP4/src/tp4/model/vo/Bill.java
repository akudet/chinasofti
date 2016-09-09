package tp4.model.vo;

/**
 *
 * @author 田霞光
 *
 */
public class Bill {
	public Bill(float bill_amount, String comment) {
		super();
		this.bill_amount = bill_amount;
		this.comment = comment;
	}
	public Bill() {
		super();
	}
	public Bill(String bill_id, float bill_amount, String bill_time,
			String comment) {
		super();
		this.bill_id = bill_id;
		this.bill_amount = bill_amount;
		this.bill_time = bill_time;
		this.comment = comment;
	}
	protected String bill_id;
	protected float bill_amount;
	protected String bill_time;
	protected String comment;
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	public float getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}
	public String getBill_time() {
		return bill_time;
	}
	public void setBill_time(String bill_time) {
		this.bill_time = bill_time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "BillType [bill_id=" + bill_id + ", bill_amount=" + bill_amount
				+ ", bill_time=" + bill_time + ", comment=" + comment + "]";
	}
	

}
