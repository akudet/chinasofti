package tp4.model.vo;

/**
 * 
 * @author 项双江
 * 
 */
public class CusType {
	protected int cusTypeNo;
	protected String cusTypeDesc;
	protected int discount;

	public CusType() {
		super();
	}

	public CusType(int cusTypeNo, String cusTypeDesc, int discount) {
		super();
		this.cusTypeNo = cusTypeNo;
		this.cusTypeDesc = cusTypeDesc;
		this.discount = discount;
	}

	public String getCusTypeDesc() {
		return cusTypeDesc;
	}

	public int getCusTypeNo() {
		return cusTypeNo;
	}

	public int getDiscount() {
		return discount;
	}

	public void setCusTypeDesc(String cusTypeDesc) {
		this.cusTypeDesc = cusTypeDesc;
	}

	public void setCusTypeNo(int cusTypeNo) {
		this.cusTypeNo = cusTypeNo;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
