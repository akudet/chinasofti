package tp4.model.vo;

/**
 * 
 * @author 马厦伟
 * 
 */
public class Vip {
	protected int vipNo;
	protected CusInfo cusInfo;

	public Vip() {

	}

	public Vip(int vipNumber) {
		super();
		this.vipNo = vipNumber;
	}

	public Vip(int vipNumber, CusInfo cusInformation) {
		super();
		this.vipNo = vipNumber;
		this.cusInfo = cusInformation;
	}

	public String getAddress() {
		return cusInfo.getAddresss();
	}

	public String getCertNo() {
		return cusInfo.getCertNumber();
	}

	public String getComment() {
		return cusInfo.getComment();
	}

	public CusInfo getCusInfo() {
		return cusInfo;
	}

	public String getName() {
		return cusInfo.getName();
	}

	public String getPhone() {
		return cusInfo.getPhone();
	}

	public String getSex() {
		return cusInfo.getSex();
	}

	public int getVipNo() {
		return vipNo;
	}

	public void setCusInfo(CusInfo cusInformation) {
		this.cusInfo = cusInformation;
	}

	public void setVipNo(int vipNumber) {
		this.vipNo = vipNumber;
	}

	@Override
	public String toString() {
		return "Vip [vipNumber=" + vipNo + ", cusInformation=" + cusInfo + "]";
	}

}
