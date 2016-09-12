package tp4.service;

import java.util.UUID;

import tp4.model.dao.CheckinDao;
import tp4.model.dao.CusInfoDao;

import tp4.model.vo.Checkin;
import tp4.model.vo.CusInfo;

import tp4.model.vo.Room;

/**
 * 
 * @author 田霞光
 * 
 */
public class CheckinService {

	// 参考 2.3 开设房间

	// 办理入住
	public int checkin(Checkin in) {
		CheckinDao dao = new CheckinDao();
		return dao.add(in);	
	}
	
	public int checkin(Room room, CusInfo cusInfo ,String checkin_time,String checkin_type,float price,int num_of_days) {
	
		Checkin checkin = new Checkin();
		CheckinDao dao = new CheckinDao();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		checkin.setCheckinId(uuid);
		checkin.setCheckinTime(checkin_time);
		checkin.setCheckinType(checkin_type);
		checkin.setCusInfo(cusInfo);
		checkin.setRoom(room);
		checkin.setNumOfDays(num_of_days);
		checkin.setPrice(price);
		return dao.add(checkin);	
 
}

	public int renew(String checkinId, int days, int deposit) {
		CheckinDao dao = new CheckinDao();
		Checkin checkin = new Checkin();
		checkin = dao.findById(checkinId);
		if(checkin.getCheckinType()=="1")
		{
			float deposit1 = 0;
			int numdays = days+checkin.getNumOfDays();
			deposit1 = numdays*checkin.getPrice();
			 
			if(deposit<deposit1)
			{
				return 0;
			}
			else
			{
				checkin.setNumOfDays(numdays);
				checkin.setDeposit(deposit1);
				return  dao.update(checkin);
			
			}
		}
		
		return -1;
	}

	public int updateCusInfo(String checkinId, String certNumber,
			String address, String comment) {
		
		CusInfoDao dao = new CusInfoDao();
		CusInfo cusinfo = new CusInfo();
		cusinfo = dao.findById(checkinId);
		cusinfo.setAddresss(address);
		cusinfo.setCertNumber(certNumber);
		cusinfo.setComment(comment);
		return dao.update(cusinfo, cusinfo.getCusType().getCusTypeNo());
		
	}
}
