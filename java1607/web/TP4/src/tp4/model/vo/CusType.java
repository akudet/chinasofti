package tp4.model.vo;
/**
 * 作者：项双江
 */
public class CusType {
	protected int cusTypeNo;
	protected String cusTypeDesc;
	protected int discount;
	
	public int getCusTypeNo() {
		return cusTypeNo;
	}
	public void setCusTypeNo(int cusTypeNo) {
		this.cusTypeNo = cusTypeNo;
	}
	public String getCusTypeDesc() {
		return cusTypeDesc;
	}
	public void setCusTypeDesc(String cusTypeDesc) {
		this.cusTypeDesc = cusTypeDesc;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public CusType(int cusTypeNo, String cusTypeDesc, int discount) {
		super();
		this.cusTypeNo = cusTypeNo;
		this.cusTypeDesc = cusTypeDesc;
		this.discount = discount;
	}
	public CusType() {
		super();
	}
	
}
