package team4.proj1.service.impl.cus;

import java.util.*;

import team4.proj1.model.dao.impl.jdbc.CusInfoDAOImpl;
import team4.proj1.model.dao.impl.jdbc.CusTypeDAOImpl;
import team4.proj1.model.dao.impl.jdbc.VipDAOImpl;
import team4.proj1.model.vo.check.Checkin;
import team4.proj1.model.vo.cus.CusInfo;
import team4.proj1.model.vo.cus.CusType;
import team4.proj1.model.vo.cus.Vip;
import team4.proj1.model.vo.room.Room;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipServiceImpl {

	// 参考 2.7 会员管理

	private VipDAOImpl mVipDao = new VipDAOImpl();
	private CusInfoDAOImpl mCusInfoDao = new CusInfoDAOImpl();
	
	//按会员名字查询
	public Vip findOneByName(String name){
		return mVipDao.findOneByName(name);
	}
	
	//通过会员编号查询
	public Vip findOneByVipNo(int vipNo){
		Vip vip = null;
		try {
			vip = mVipDao.findOneByVipNo("" + vipNo);
		} catch(NumberFormatException e) {
			return vip;
		}
		return vip;
	}
	
	public int add(int vipNumber, String name, String sex, String certNumber,
			String phone, String address, String comment) {
		CusInfo user = new CusInfo("身份证", certNumber, name, phone, address,
				sex, comment);
		CusTypeDAOImpl dao = new CusTypeDAOImpl();
		CusType cusType = dao.findById(CusType.VIP_CUS_TYPE_NO);
		user.setCusType(cusType);

		Vip vip = new Vip(vipNumber, user);

		return mVipDao.add(vip);

	}

	public int deleteByVipNo(int vipNumber) {

		return mVipDao.deleteByVipNo(vipNumber);
	}

	public Vip findOneByVipNo(String vipNumber) {
		return mVipDao.findOneByVipNo(vipNumber);
	}

	// 根据提供的信息对信息进行修改
	public int update(int vipNumber, String name, String sex,
			String certNumber, String phone, String address, String comment) {
		Vip vip = mVipDao.findOneByVipNo("" + vipNumber);
		CusInfo cusInfo = vip;
		cusInfo.setName(name);
		cusInfo.setSex(sex);
		cusInfo.setCertNumber(certNumber);
		cusInfo.setPhone(phone);
		cusInfo.setAddress(address);
		cusInfo.setComment(comment);
		return mCusInfoDao.update(cusInfo, cusInfo.getCusType().getCusTypeNo());

	}

	public List<Vip> findAll() {
		return mVipDao.findAll();
	}
}
