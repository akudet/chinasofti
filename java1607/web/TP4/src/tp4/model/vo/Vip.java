package tp4.model.vo;

/**
 *
 * @author 马厦伟
 *
 */
public class Vip {
	protected int vipNumber;
	protected CusInfo cusInformation;
	public Vip() {
	
	}
	@Override
	public String toString() {
		return "Vip [vipNumber=" + vipNumber + ", cusInformation="
				+ cusInformation + "]";
	}
	public Vip(int vipNumber, CusInfo cusInformation) {
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
	public CusInfo getCusInformation() {
		return cusInformation;
	}
	public void setCusInformation(CusInfo cusInformation) {
		this.cusInformation = cusInformation;
	}

	
	
}
