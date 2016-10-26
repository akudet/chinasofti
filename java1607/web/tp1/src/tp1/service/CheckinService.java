package tp1.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import tp1.model.dao.CheckinDAO;
import tp1.model.dao.CusInfoDAO;
import tp1.model.dao.CusTypeDAO;
import tp1.model.dao.RoomDAO;
import tp1.model.dao.VipDAO;
import tp1.model.vo.Checkin;
import tp1.model.vo.Checkout;
import tp1.model.vo.CusInfo;
import tp1.model.vo.CusType;
import tp1.model.vo.Room;
import tp1.model.vo.RoomType;
import tp1.model.vo.Vip;

/**
 * 
 * @author 巫金桐
 * 
 */
public class CheckinService {

	private final CheckinDAO mCheckinDao;
	private final CusInfoDAO mCusInfoDao;
	private final RoomDAO mRoomDao;
	final float EPSILON = 0.005f;
	private final VipDAO mVipDao;


	// 参考 2.3 开设房间

	public CheckinService() {
		super();
		this.mCheckinDao = new CheckinDAO();
		this.mCusInfoDao = new CusInfoDAO();
		this.mRoomDao = new RoomDAO();
		this.mVipDao = new VipDAO();
	}
	
	private float getPrice(RoomType roomType, CusType cusType, int chargeType) {
		float discount = cusType.getDiscount();
		discount /= 10.0f;
		float price;
		if (chargeType == RoomType.NORMAL_ROOM) {
			price = roomType.getPrice();
		} else if (chargeType == RoomType.HOUR_ROOM) {
			price = roomType.getHourRoomPrice();
		} else {
			throw new CheckinServiceException("未知收费类型");
		}
		
		price *= discount;
		return price;
	}

	// 办理入住
	public Checkin checkin(String roomId, CusInfo cusInfo, String vip_no, 
			String checkin_type_no, String num_of_days, String deposit) {
		
		Room room = mRoomDao.findById(roomId);
		if (null == room) {
			throw new CheckinServiceException("房间未找到");
		}
		room.setStatusInuse();
		mRoomDao.update(room);
		
		Checkin checkin = new Checkin();
		Date now = new Date();
		
		if (cusInfo.isVip() && vip_no != null && !vip_no.equals("")) {
			Vip vip = mVipDao.findById(vip_no);
			if (null == vip) {
				throw new CheckinServiceException("会员编号：" + vip_no + "不存在");
			}
			cusInfo = vip.getCusInfo();
		}
		
		checkin.setCheckinId("in" + new SimpleDateFormat("yyyyMMddHHmmss").format(now));
		checkin.setRoom(room);
		checkin.setCusInfo(cusInfo);
		checkin.setCheckinTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));
		checkin.setCheckinType(Integer.parseInt(checkin_type_no));
		checkin.setPrice(getPrice(room.getRoomType(), cusInfo.getCusType(), checkin.getCheckinType()));
		checkin.setNumOfDays(Integer.parseInt(num_of_days));
		checkin.setDeposit(Float.parseFloat(deposit));
		
		if (checkin.getCheckinType() == RoomType.NORMAL_ROOM) {
			if (checkin.getDeposit() - checkin.getNumOfDays() * checkin.getPrice() <= EPSILON) {
				throw new CheckinServiceException("计费方式为“标准”时，应押金>单价*预住天数");
			}
		} else {
			checkin.setDeposit(checkin.getPrice() * 5);
			if (checkin.getDeposit() - checkin.getPrice() * 5 >= EPSILON) {
				throw new CheckinServiceException("计费方式为“钟点”时，应押金=单价*5");
			}
		}
		
		// this is ok if user choose vip_no, and we got duplicatee key
		mCusInfoDao.add(cusInfo);
		mCheckinDao.add(checkin);

		return checkin;
	}
	
	public List<Checkin> findAll() {
		return mCheckinDao.findAll();
	}
	
	public Checkin findById(String checkinId) {
		return mCheckinDao.findById(checkinId);
	}

	// 续住
	public Checkin renew(String checkinId, String p_days, String p_deposit) {
		Checkin checkin  = mCheckinDao.findById(checkinId);
		int chargeType = checkin.getCheckinType();
		
		if (chargeType == RoomType.HOUR_ROOM) {
			throw new CheckinServiceException("钟点房不能续住");
		}
		
		int days = Integer.parseInt(p_days);
		float deposit = Float.parseFloat(p_deposit);
		
		float newDeposit = checkin.getDeposit() + deposit;
		int newNumOfDays = days + checkin.getNumOfDays();
		
		if (newDeposit -  checkin.getPrice() * newNumOfDays <= EPSILON) {
			throw new CheckinServiceException("续缴押金：续缴押金后总金额应>单价*续住后总天数");
		}
			
		checkin.setDeposit(newDeposit);
		checkin.setNumOfDays(newNumOfDays);
		
		mCheckinDao.update(checkin);

		return checkin;
	}

	public int updateCheckin(String checkinId, String certNumber,
			String address, String comment) {
		
		CusInfo cusinfo = mCheckinDao.findById(checkinId).getCusInfo();
		
		cusinfo.setAddress(address);
		cusinfo.setCertNumber(certNumber);
		cusinfo.setComment(comment);
		
		return mCusInfoDao.update(cusinfo);

	}
	
	
	//查询所有可以续住的房间
	public List<Checkin> findAllRenew(){
		return mCheckinDao.findAll(RoomType.NORMAL_ROOM, Checkin.UNCHECK);
	}

	public List<Checkin> findUncheckByCus(String name, String roomId,
			String cusTypeNo) {
		 return mCheckinDao.findUncheckByCus(name, roomId, cusTypeNo);
	}

	public List<Room> findFreeRooms(String roomTypeNo) {
		return mRoomDao.findFreeRoom(roomTypeNo);
	}

	public List<Checkin> findAllUncheck() {
		return mCheckinDao.findByStatus(Checkin.UNCHECK);
	}
	
	public List<Checkin> findAllChecked() {
		return mCheckinDao.findByStatus(Checkin.CHECKED);
	}
}
