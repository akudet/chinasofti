package tp4.model.dao;

public class RoomType {

	protected int typeNo;
	protected String typeDesc;
	protected int beds;
	public int getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}
	@Override
	public String toString() {
		return "RoomType [typeNo=" + typeNo + ", typeDesc=" + typeDesc
				+ ", beds=" + beds + "]";
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
}
