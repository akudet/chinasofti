package tp4.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp4.model.dao.CheckinDao;
import tp4.model.dao.CheckoutDao;
import tp4.model.dao.RoomDao;
import tp4.model.vo.Checkin;
import tp4.model.vo.Checkout;
import tp4.model.vo.Room;

/**
 * 
 * @author 项双江
 * 
 */
public class CheckoutService {
	// 参考 2.4 客户结账, 2.6 营业查询

	/**
	 * 办理结帐
	 * 
	 * @param room
	 *            结帐房间
	 * @param amount
	 *            实收金额个
	 * @param res
	 *            找零, 如果结帐成功,则在末尾添加找零,否则不作修改
	 * @return 执行结果 0 表示成功
	 */
	public int checkout(Room room, float amount, List<Float> res) {
		CheckinDao dao1 = new CheckinDao();
		Checkin room1 = dao1.findByRoomId(room.getRoomId());
		if (room1.getCheckinType().equals("标准")) {
			Date d1 = new Date();
			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
			try {
				Date d2 = df.parse(room1.getCheckinTime());
				long time1 = d1.getTime();
				long time2 = d2.getTime();
				long time = time1 - time2;
				float a = time / 1000 / 60 / 60 / 24;
				int days = (int) (Math.ceil(a));
				float cost = days * room1.getPrice();
				if ((room1.getDeposit() + amount) >= cost) {
					float b = room1.getDeposit() + amount - cost;
					res.add(b);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Date d1 = new Date();
			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
			try {
				Date d2 = df.parse(room1.getCheckinTime());
				long time1 = d1.getTime();
				long time2 = d2.getTime();
				long time = time1 - time2;
				float a = time / 1000 / 60 / 60;
				int hours = Math.round(a);
				float cost = hours * room1.getPrice();
				if ((room1.getDeposit() + amount) >= cost) {
					float c = room1.getDeposit() + amount - cost;
					res.add(c);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public List<Checkout> find() {
		CheckoutDao dao = new CheckoutDao();
		return dao.findAll();
	}

	public ArrayList<Checkout> find(Date start, Date end, int checkType,
			List<Integer> roomTypeNos) {
		CheckoutDao dao = new CheckoutDao();
		return dao.find(start, end, checkType, roomTypeNos);
	}
	
	public ArrayList<Checkout> find(String start, String end, String checkinType,
			String[] roomTypeNos) {
		System.out.println("FIND : " + start + end + checkinType + roomTypeNos);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date s_start = null;
		Date e_end = null;
		try {
			s_start = df.parse(start);
			e_end = df.parse(start);
		} catch (ParseException e) {
		}
		
		if (null == s_start || null == e_end) {
			return null;
		}
		
		int c_checkinType = Integer.parseInt(checkinType);
		List<Integer> r_roomTypeNos = parseInt(roomTypeNos);
		
		return find(s_start, e_end, c_checkinType, r_roomTypeNos);
		
	}

	private List<Integer> parseInt(String[] roomTypeNos) {
		List<Integer> res = new ArrayList<Integer>();
		for (String roomTypeNo : roomTypeNos) {
			res.add(Integer.parseInt(roomTypeNo));
		}
		return res;
	}

	public List<Checkout> find(int checkType,
			List<Integer> roomTypeNos) {
		Date start = new Date();
		Date end = new Date();
		return find(start, end, checkType, roomTypeNos);
	}

	public List<Checkout> find(String name, String roomId, String status,
			String cusTypeDesc) {
		CheckoutDao dao = new CheckoutDao();
		return dao.find(name, roomId, status, cusTypeDesc);
	}

	public List<Checkout> findInProcess(String name, String roomId,
			String cusTypeDesc) {
		return null;
	}

	public List<Checkout> findProcessed(String name, String roomId,
			String cusTypeDesc) {
		return null;
	}
}
