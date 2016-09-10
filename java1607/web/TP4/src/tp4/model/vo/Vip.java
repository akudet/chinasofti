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

	public Vip(int vipNumber, CusInfo cusInformation) {
		super();
		this.vipNumber = vipNumber;
		this.cusInformation = cusInformation;
	}

	public CusInfo getCusInformation() {
		return cusInformation;
	}

	public int getVipNumber() {
		return vipNumber;
	}

	public void setCusInformation(CusInfo cusInformation) {
		this.cusInformation = cusInformation;
	}

	public void setVipNumber(int vipNumber) {
		this.vipNumber = vipNumber;
	}

	@Override
	public String toString() {
		return "Vip [vipNumber=" + vipNumber + ", cusInformation="
				+ cusInformation + "]";
	}

}
