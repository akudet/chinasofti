package tp1.model.vo.check;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp1.model.vo.ValueObject;

public class ChargeType extends ValueObject {
	
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
