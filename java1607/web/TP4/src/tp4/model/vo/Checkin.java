package tp4.model.vo;

/**
 * 
 * @author 田霞光
 * 
 */
public class Checkin {

	protected String checkinId;
	protected Room room;

	protected CusInfo cusInfo;
	protected String checkinTime;
	protected String checkinType;
	protected float price;
	protected int numOfDays;
	protected float deposit;

	public Checkin() {
		super();
	}

	public Checkin(String checkin_id, Room room, CusInfo cus_info_id,
			String checkin_time, String checkin_type, float price,
			int num_of_days, float deposit) {
		super();
		this.checkinId = checkin_id;
		this.room = room;
		this.cusInfo = cus_info_id;
		this.checkinTime = checkin_time;
		this.checkinType = checkin_type;
		this.price = price;
		this.numOfDays = num_of_days;
		this.deposit = deposit;
	}

	public String getCheckinId() {
		return checkinId;
	}

	public String getCheckinTime() {
		return checkinTime;
	}

	public String getCheckinType() {
		return checkinType;
	}

	public CusInfo getCusInfo() {
		return cusInfo;
	}

	public float getDeposit() {
		return deposit;
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public float getPrice() {
		return price;
	}

	public Room getRoom() {
		return room;
	}

	public void setCheckinId(String checkinId) {
		this.checkinId = checkinId;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public void setCheckinType(String checkinType) {
		this.checkinType = checkinType;
	}

	public void setCusInfo(CusInfo cusInfo) {
		this.cusInfo = cusInfo;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}