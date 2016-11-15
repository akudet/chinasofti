package tp1.service;

import java.util.*;

import tp1.model.dao.impl.jdbc.CusInfoDAO;
import tp1.model.dao.impl.jdbc.CusTypeDAO;
import tp1.model.dao.impl.jdbc.VipDAOImpl;
import tp1.model.vo.check.Checkin;
import tp1.model.vo.cus.CusInfo;
import tp1.model.vo.cus.CusType;
import tp1.model.vo.cus.Vip;
import tp1.model.vo.room.Room;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipService {

	// 参考 2.7 会员管理

	private VipDAOImpl mVipDao = new VipDAOImpl();
	private CusInfoDAO mCusInfoDao = new CusInfoDAO();
	
	//按会员名字查询
	public Vip findVipByName(String name){
		return mVipDao.findOneByName(name);
	}
	
	//通过会员编号查询
	public Vip findVipByVipNo(int vipNo){
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
		CusTypeDAO dao = new CusTypeDAO();
		CusType cusType = dao.findById(CusType.VIP_CUS_TYPE_NO);
		user.setCusType(cusType);

		Vip vip = new Vip(vipNumber, user);

		return mVipDao.add(vip);

	}

	public int deleteById(int vipNumber) {

		return mVipDao.deleteByVipNo(vipNumber);
	}

	public Vip findById(String vipNumber) {
		return mVipDao.findOneByVipNo(vipNumber);
	}

	// 根据提供的信息对信息进行修改
	public int updateById(int vipNumber, String name, String sex,
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
