package tp4.service;

import java.util.*;

import tp4.model.dao.CusInfoDao;
import tp4.model.dao.CusTypeDao;
import tp4.model.dao.VipDao;
import tp4.model.vo.CusInfo;
import tp4.model.vo.CusType;
import tp4.model.vo.Room;
import tp4.model.vo.Vip;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipService {

	// 参考 2.7 会员管理

	private VipDao mVipDao = new VipDao();
	private CusInfoDao mCusInfoDao = new CusInfoDao();
	
	//按会员名字查询
	public Vip findVipByName(String name){
		return mVipDao.findByName(name);
	}
	
	//通过会员编号查询
	public Vip findVipByVipNo(int vipNo){
		Vip vip = null;
		try {
			vip = mVipDao.findById("" + vipNo);
		} catch(NumberFormatException e) {
			return vip;
		}
		return vip;
	}
	
	public int add(int vipNumber, String name, String sex, String certNumber,
			String phone, String address, String comment) {
		CusInfo user = new CusInfo("身份证", certNumber, name, phone, address,
				sex, comment);
		CusTypeDao dao = new CusTypeDao();
		CusType cusType = dao.findById(CusType.VIP_CUS_TYPE_NO);
		user.setCusType(cusType);

		Vip vip = new Vip(vipNumber, user);

		return mVipDao.add(vip);

	}

	public int deleteById(int vipNumber) {

		return mVipDao.deleteById(vipNumber);
	}

	public Vip findById(String vipNumber) {
		Integer.parseInt(vipNumber);
		return mVipDao.findById(vipNumber);
	}

	// 根据提供的信息对信息进行修改
	public int updateById(int vipNumber, String name, String sex,
			String certNumber, String phone, String address, String comment) {
		Vip vip = mVipDao.findById("" + vipNumber);
		CusInfo cusInfo = vip.getCusInfo();
		cusInfo.setName(name);
		cusInfo.setSex(sex);
		cusInfo.setCertNumber(certNumber);
		cusInfo.setPhone(phone);
		cusInfo.setAddress(address);
		cusInfo.setComment(comment);
		return mCusInfoDao.update(cusInfo, cusInfo.getCusType().getCusTypeNo());

	}
}
