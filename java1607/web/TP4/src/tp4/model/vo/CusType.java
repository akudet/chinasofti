package tp4.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author 项双江
 * 
 */
public class CusType extends VirtualObject {
	protected int cusTypeNo;
	protected String cusTypeDesc;
	protected int discount;

	public static final int VIP_CUS_TYPE_NO = 1;
	
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

	@Override
	public void map(ResultSet rs) throws SQLException {
		cusTypeNo = rs.getInt("cus_type_no");
		cusTypeDesc = rs.getString("cus_type_desc");
		discount = rs.getInt("discount");

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

	public boolean isVip() {
		return cusTypeNo == VIP_CUS_TYPE_NO;
	}

}
