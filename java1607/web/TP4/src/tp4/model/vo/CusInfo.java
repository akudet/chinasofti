package tp4.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * 
 * @author 项双江
 * 
 */
public class CusInfo extends VirtualObject {
	protected String cusInfoId;
	protected String certType;
	protected String certNumber;
	protected String name;
	protected String phone;
	protected String addresss;
	protected String sex;
	protected CusType cusType;
	protected String comment;

	public CusInfo() {
		super();
	}

	public CusInfo(String certType, String certNumber, String name,
			String phone, String addresss, String sex, String comment) {
		super();
		this.cusInfoId = UUID.randomUUID().toString().replace("-", "");
		this.certType = certType;
		this.certNumber = certNumber;
		this.name = name;
		this.phone = phone;
		this.addresss = addresss;
		this.sex = sex;
		this.comment = comment;
	}

	public CusInfo(String cusInfoId, String certType, String certNumber,
			String name, String phone, String addresss, String sex,
			String comment) {
		super();
		this.cusInfoId = cusInfoId;
		this.certType = certType;
		this.certNumber = certNumber;
		this.name = name;
		this.phone = phone;
		this.addresss = addresss;
		this.sex = sex;
		this.comment = comment;
	}

	public String getAddresss() {
		return addresss;
	}

	public String getCertNumber() {
		return certNumber;
	}

	public String getCertType() {
		return certType;
	}

	public String getComment() {
		return comment;
	}

	public String getCusInfoId() {
		return cusInfoId;
	}

	public CusType getCusType() {
		return cusType;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getSex() {
		return sex;
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		cusInfoId = rs.getString("cus_info_id");
		certType = rs.getString("cert_type");
		certNumber = rs.getString("cert_number");
		name = rs.getString("name");
		phone = rs.getString("phone");
		addresss = rs.getString("address");
		sex = rs.getString("sex");
		comment = rs.getString("comment");

	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCusInfoId(String cusInfoId) {
		this.cusInfoId = cusInfoId;
	}

	public void setCusType(CusType cusType) {
		this.cusType = cusType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
