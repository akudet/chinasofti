package tp4.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChargeType extends VirtualObject {
	
	private int chargeTypeNo;
	private String chargeTypeDesc;

	public ChargeType(int chargeTypeNo, String chargeTypeDesc) {
		super();
		this.chargeTypeNo = chargeTypeNo;
		this.chargeTypeDesc = chargeTypeDesc;
	}

	public int getChargeTypeNo() {
		return chargeTypeNo;
	}

	public String getChargeTypeDesc() {
		return chargeTypeDesc;
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub

	}

}
