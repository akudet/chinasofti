package tp1.model.vo.cus;

/**
 * 
 * @author 马厦伟
 * 
 */
public class Vip extends CusInfo {
	
	public Vip(int vipNo, CusInfo cusInfo) {
		this.setAddress(cusInfo.getAddress());
		this.setCertNumber(cusInfo.getCertNumber());
		this.setCertType(cusInfo.getCertType());
		this.setComment(cusInfo.getComment());
		this.setCusInfoId(cusInfo.getCusInfoId());
		this.setCusType(cusInfo.getCusType());
		this.setName(cusInfo.getName());
		this.setPhone(cusInfo.getPhone());
		this.setSex(cusInfo.getSex());
		this.setVipNo(vipNo);
	}

	public Vip() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toXML() {
		String xml = "<vip>" + "<vip_no>" + getVipNo() + "</vip_no>" + "<name>"
				+ getName() + "</name>" + "<sex>" + getSex() + "</sex>"
				+ "<cert_number>" + getCertNumber() + "</cert_number>"
				+ "<address>" + getAddress() + "</address>" + "<comment>"
				+ getComment() + "</comment>" + "</vip>";
		return xml;

	}

}
