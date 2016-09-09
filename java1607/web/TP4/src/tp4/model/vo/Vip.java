package tp4.model.vo;
/**
 * 
 * @author Chris
 *
 */
public class Vip {
	protected int vipNumber;
	protected String cusInformation;
	public Vip() {
	
	}
	public Vip(int vipNumber, String cusInformation) {
		super();
		this.vipNumber = vipNumber;
		this.cusInformation = cusInformation;
	}
	public int getVipNumber() {
		return vipNumber;
	}
	public void setVipNumber(int vipNumber) {
		this.vipNumber = vipNumber;
	}
	public String getCusInformation() {
		return cusInformation;
	}
	public void setCusInformation(String cusInformation) {
		this.cusInformation = cusInformation;
	}
	@Override
	public String toString() {
		return "VipDao [vipNumber=" + vipNumber + ", cusInformation="
				+ cusInformation + "]";
	}
}
