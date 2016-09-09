package tp4.model.vo;
/**
 * 作者：项双江
 */
public class CusInfo {
	protected String cusInfoId;
	protected String certType;
	protected String certNumber;
	protected String name;
	protected String phone;
	protected String addresss;
	protected String sex;
	protected CusType cusType;
	protected String comment;
	

	public String getCusInfoId() {
		return cusInfoId;
	}


	public void setCusInfoId(String cusInfoId) {
		this.cusInfoId = cusInfoId;
	}


	public String getCertType() {
		return certType;
	}


	public void setCertType(String certType) {
		this.certType = certType;
	}


	public String getCertNumber() {
		return certNumber;
	}


	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddresss() {
		return addresss;
	}


	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public CusType getCusType() {
		return cusType;
	}


	public void setCusType(CusType cusType) {
		this.cusType = cusType;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public CusInfo(String cusInfoId, String certType, String certNumber,
			String name, String phone, String addresss, String sex, String comment) {
		super();
		this.cusInfoId = cusInfoId;
		this.certType = certType;
		this.certNumber = certNumber;
		this.name = name;
		this.phone = phone;
		this.addresss = addresss;
		this.sex = sex;
		this.cusType = cusType;
		this.comment = comment;
	}


	public CusInfo() {
		super();
	}
	
}
