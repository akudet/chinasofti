package tp1.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp1.model.dao.impl.jdbc.CheckinDAO;
import tp1.model.dao.impl.jdbc.CheckoutDAO;
import tp1.model.dao.impl.jdbc.RoomDAO;
import tp1.model.vo.check.Checkin;
import tp1.model.vo.check.Checkout;
import tp1.model.vo.room.Room;

/**
 * 
 * @author 巫金桐
 * 
 */
public class CheckoutService {
	// 参考 2.4 客户结账, 2.6 营业查询

	private final CheckinDAO mCheckinDao;
	private final CheckoutDAO mCheckoutDao;
	private final RoomDAO mRoomDao;

	public CheckoutService() {
		super();
		this.mCheckinDao = new CheckinDAO();
		this.mCheckoutDao = new CheckoutDAO();
		this.mRoomDao = new RoomDAO();
	}

	// em , pretty bad consider with diffInHours
	private int diffInDays(Date start, Date end) {
		int days = (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24);
		if (days == 0) {
			days = 1;
		}
		return days;
	}

	private float diffInHours(Date start, Date end) {
		long minutes = (end.getTime() - start.getTime()) / 1000 / 60;
		long hours = minutes / 60;
		float res = hours;
		long mod = minutes % 60;
		if (mod > 40) {
			res += 1.0f;
		} else if (mod > 10) {
			res += 0.5f;
		}
		return res;
	}

	public Checkout checkout(String checkinId, String amount, String comment)
			throws CheckoutServiceException {
		Checkin checkin = mCheckinDao.findById(checkinId);

		int chargeType = checkin.getCheckinType();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = null;
		try {
			start = df.parse(checkin.getCheckinTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = new Date();

		float charge;
		// System.out.println("PRICE : " + checkin.getPrice());
		// System.out.println(diffInDays(start, end));
		// System.out.println(diffInHours(start, end));
		switch (chargeType) {
		case 0:
			charge = diffInDays(start, end) * checkin.getPrice();
			break;
		case 1:
			charge = diffInHours(start, end) * checkin.getPrice();
			break;
		default:
			throw new CheckoutServiceException("未知收费类型");
		}

		Checkout checkout = new Checkout();

		checkout.setCheckin(checkin);
		checkout.setCheckoutId("out"
				+ new SimpleDateFormat("yyyyMMddhhmmss").format(end));
		checkout.setCheckoutAmount(charge);
		checkout.setCheckoutTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(end));
		checkout.setComment(comment);

		Room room = checkin.getRoom();

		room.setStatusFree();
		mRoomDao.update(room);

		checkin.setChecked();
		mCheckinDao.update(checkin);

		mCheckoutDao.add(checkout);

		return checkout;
	}

	public List<Checkout> findAll() {
		return mCheckoutDao.findAll();
	}

	// status should be CHECKED or UNCHECKED
	public List<Checkout> findByCus(String name, String roomId, String cusTypeNo) {
		System.out.println("FindByCus : " + name + roomId + cusTypeNo);

		return mCheckoutDao.findByCus(name, roomId, cusTypeNo);
	}

	public List<Checkout> findByRoom(String start, String end,
			String checkinType, String[] roomTypeNos) {
		System.out.println("FindByRoom : " + start + end + checkinType
				+ roomTypeNos);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date s_start;
		Date e_end;
		try {
			s_start = df.parse(start);
			e_end = df.parse(end);
		} catch (ParseException e) {
			Date now = new Date();
			start = df.format(now);
			end = df.format(now);
		}

		List<Integer> r_roomTypeNos = parseInt(roomTypeNos);

		return mCheckoutDao.findByRoom(start, end, checkinType,
				r_roomTypeNos);
	}

	private List<Integer> parseInt(String[] roomTypeNos) {
		List<Integer> res = new ArrayList<Integer>();
		if (null == roomTypeNos) {
			return res;
		}
		for (String roomTypeNo : roomTypeNos) {
			res.add(Integer.parseInt(roomTypeNo));
		}
		return res;
	}

	public Checkin findByCheckinId(String checkinId) {
		Checkin checkin = mCheckinDao.findById(checkinId);
		if (checkin != null && checkin.isChecked()) {
			throw new CheckoutServiceException("该房间已经结账");
		}
		return checkin;
	}

	// 通过房间号查找未结账的登记信息
	public Checkin findByRoomId(String roomId) {
		Checkin checkin = mCheckinDao.findByRoomId(roomId);
		return checkin;
	}

	// 分页查询
	public List<Checkout> findAll(int pageNo) {

		return mCheckoutDao.findAll(pageNo);
	}

	// 查询总页数
	public int getTotalPage() {
		return mCheckoutDao.getTotalPage();
	}

	public List<Checkin> findAllUncheck() {
		return mCheckinDao.findAllByCheckinStatus(Checkin.UNCHECK);
	}
}
