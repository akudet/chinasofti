package tp4.model.vo;

/**
 *
 * @author 田霞光
 *
 */
public class Checkin {

	public Checkin(String checkin_id, Room room, CusInfo cus_info_id,
			String checkin_time, String checkin_type, float price,
			int num_of_days, float deposit) {
		super();
		this.checkin_id = checkin_id;
		this.room = room;
		this.cus_info_id = cus_info_id;
		this.checkin_time = checkin_time;
		this.checkin_type = checkin_type;
		this.price = price;
		this.num_of_days = num_of_days;
		this.deposit = deposit;
	}
	public Checkin() {
		super();
	}
	

	protected String checkin_id;
	 protected Room room;
	protected CusInfo cus_info_id;
	protected String checkin_time;
    protected String checkin_type;
    protected float price;
    protected int num_of_days;
    protected float deposit;
   
	public String getCheckin_id() {
		return checkin_id;
	}
	public void setCheckin_id(String checkin_id) {
		this.checkin_id = checkin_id;
	}
	public String getCheckin_time() {
		return checkin_time;
	}
	public void setCheckin_time(String checkin_time) {
		this.checkin_time = checkin_time;
	}
	public String getCheckin_type() {
		return checkin_type;
	}
	public void setCheckin_type(String checkin_type) {
		this.checkin_type = checkin_type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum_of_days() {
		return num_of_days;
	}
	public void setNum_of_days(int num_of_days) {
		this.num_of_days = num_of_days;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public CusInfo getCus_info_id() {
		return cus_info_id;
	}
	public void setCus_info_id(CusInfo cus_info_id) {
		this.cus_info_id = cus_info_id;
	}
	
}
