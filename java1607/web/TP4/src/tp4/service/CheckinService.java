package tp4.service;

import java.util.List;
import java.util.UUID;

import tp4.model.dao.CheckinDao;
import tp4.model.dao.CusInfoDao;
import tp4.model.dao.CusTypeDao;
import tp4.model.dao.RoomDao;
import tp4.model.vo.Checkin;
import tp4.model.vo.CusInfo;
import tp4.model.vo.CusType;
import tp4.model.vo.Room;

/**
 * 
 * @author 田霞光
 * 
 */
public class CheckinService {

	private CheckinDao mCheckinDao;

	// 参考 2.3 开设房间

	public CheckinService() {
		super();
		this.mCheckinDao = new CheckinDao();
	}

	public Checkin findById(String checkinId) {
		return mCheckinDao.findById(checkinId);
	}
	
	public List<Checkin> findAll() {
		return mCheckinDao.findAll();
	}
	
	// 办理入住
	public int checkin(String roomId, CusInfo cusInfo,
			String checkin_type, String price, String num_of_days) {

		Checkin checkin = new Checkin();
		CheckinDao dao = new CheckinDao();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		checkin.setCheckinId(uuid);
		checkin.setCheckinType(checkin_type);
		checkin.setCusInfo(cusInfo);
		checkin.setRoom(new RoomDao().findById(roomId));
		checkin.setNumOfDays(Integer.parseInt(num_of_days));
		checkin.setPrice(Float.parseFloat(price));
		return dao.add(checkin);

	}

	// 续住
	public int renew(String checkinId, int days, int deposit) {
		CheckinDao dao = new CheckinDao();
		Checkin checkin = new Checkin();
		checkin = dao.findById(checkinId);
		if (checkin.getCheckinType() == "1") {
			float deposit1 = 0;
			int numdays = days + checkin.getNumOfDays();
			deposit1 = numdays * checkin.getPrice();

			if (deposit < deposit1) {
				return 0;
			} else {
				checkin.setNumOfDays(numdays);
				checkin.setDeposit(deposit1);
				return dao.update(checkin);

			}
		}

		return -1;
	}

	public int updateCusInfo(String checkinId, String certNumber,
			String address, String comment) {

		CheckinDao dao = new CheckinDao();
		CusInfo cusinfo = dao.findById(checkinId).getCusInfo();
		cusinfo.setAddress(address);
		cusinfo.setCertNumber(certNumber);
		cusinfo.setComment(comment);
		return new CusInfoDao().update(cusinfo, cusinfo.getCusType()
				.getCusTypeNo());

	}
}
