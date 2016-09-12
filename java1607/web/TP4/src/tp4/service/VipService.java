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

	//参考 2.7 会员管理
	
	private VipDao mVipDao = new VipDao();
	
	public int add(int vipNumber, String name, String sex, String certNumber,
			String phone, String address, String comment) {
		CusInfo user = new CusInfo( "身份证", certNumber,
				name, phone,address,sex,comment);
		CusTypeDao dao = new CusTypeDao();
		CusType cusType = dao.findById(1);
		user.setCusType(cusType);
		
		
		Vip vip = new Vip(vipNumber,user);
		
		return mVipDao.add(vip);
		
	}

	public int deleteById(int vipNumber) {
		
		return mVipDao.deleteById(vipNumber);
	}

	public Vip findById(String vipNumber) {
		 Integer.parseInt(vipNumber);
		return mVipDao.findById(vipNumber);
	}

	public List<Vip> findByName(String name) {
		List<Vip> mVip = mVipDao.findAll();
		List<Vip> results = new ArrayList<Vip>();
		for(Vip vip : mVip){
			if(vip.getCusInformation().getName().equals(name)){
				results.add(vip);
			}
		}if (results.size() == 0) {
			return null;
		}
		return null;
	}

	// 根据提供的信息对信息进行修改
	public int updateById(int vipNumber, String name, String sex,
			String certNumber, String phone, String address, String comment) {
		Vip vip = new Vip();
	    CusInfo mCusInfo = vip.getCusInformation();
	    CusInfoDao mCusInfoDao = new CusInfoDao();
	    CusType mCusType = new CusType();
		return mCusInfoDao.update(mCusInfo,mCusType.getCusTypeNo());

	}
}
