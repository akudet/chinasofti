package tp1.service;

import java.util.*;

import tp1.model.dao.CusInfoDAO;
import tp1.model.dao.CusTypeDAO;
import tp1.model.dao.VipDAO;
import tp1.model.vo.Checkin;
import tp1.model.vo.CusInfo;
import tp1.model.vo.CusType;
import tp1.model.vo.Room;
import tp1.model.vo.Vip;

/**
 * 
 * @author 马厦伟
 * 
 */
public class VipService {

	// 参考 2.7 会员管理

	private VipDAO mVipDao = new VipDAO();
	private CusInfoDAO mCusInfoDao = new CusInfoDAO();
	
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
		CusTypeDAO dao = new CusTypeDAO();
		CusType cusType = dao.findById(CusType.VIP_CUS_TYPE_NO);
		user.setCusType(cusType);

		Vip vip = new Vip(vipNumber, user);

		return mVipDao.add(vip);

	}

	public int deleteById(int vipNumber) {

		return mVipDao.deleteById(vipNumber);
	}

	public Vip findById(String vipNumber) {
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

	public List<Vip> findAll() {
		return mVipDao.findAll();
	}
}
