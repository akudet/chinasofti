package tp1.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp1.model.dao.ReservationDAO;
import tp1.model.dao.RoomDAO;
import tp1.model.vo.Reservation;
import tp1.model.vo.Room;

/**
 * 
 * @author 巫金桐
 * 
 */
public class ReservationService {
	
	private final ReservationDAO mReservationDao;
	private final RoomDAO mRoomDao;

	public ReservationService() {
		super();
		this.mRoomDao = new RoomDAO();
		this.mReservationDao = new ReservationDAO();
	}
	
	public int deleteById(String reservationId) {
		ReservationDAO Res = new ReservationDAO();
		Reservation reservation = Res.findById(reservationId);
		if (reservation == null) {
			return -1;
		} else {
			Room room = reservation.getRoom();
			room.setStatusFree();
			mRoomDao.update(room);
			return Res.deleteById(reservationId);
		}
	}

	public Reservation findByNameAndPhone(String name, String phone) {
		Reservation reservation = mReservationDao.findByNameAndPhone(name, phone);
		if (reservation == null) {
			return null;
		}
		return reservation;
	}

	private Room findFreeRoom(String roomTypeNo) {
		List<Room> rooms = mRoomDao.findFreeRoom(roomTypeNo);
		if (null == rooms || rooms.size() == 0) {
			return null;
		}
		return rooms.get(0);
	}

	public Reservation reserve(String roomTypeNo, String name, String phone,
			String arriveTime, String reserveTime, String comment) {

		
		Room room = findFreeRoom(roomTypeNo);
		if (room == null) {
			throw new ReservationServiceException("没有空闲房间");
		}
		
		Reservation reservation = new Reservation();
		
		if (name.equals("") || phone.equals("")) {
			throw new ReservationServiceException("姓名和电话必须都不为空");
		}
		
		reservation.setName(name);
		reservation.setPhone(phone);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date now = new Date();
		
		try {
			Date arrive = df.parse(arriveTime);
			Date reserve = df.parse(reserveTime);
			
			
			long hours = diffInHours(arrive, now);
			if (hours > 72 || hours < 0) {
				throw new RuntimeException("预定时间不得超过当前时间72小时");
			}
			
			hours =  diffInHours(reserve, arrive);
			if (hours > 5 || hours < 0) {
				throw new RuntimeException("保留时间不得超过预定时间5小时");
			}
		} catch (ParseException e1) {
			throw new RuntimeException("时间格式错误");
		}
		
		reservation.setArriveTime(arriveTime);
		reservation.setReserveTime(reserveTime);
		reservation.setComment(comment);

		reservation.setRoom(room);
		room.setStatusReserved();
		mRoomDao.update(room);
		
		mReservationDao.add(reservation);
		
		return reservation;
	}

	private long diffInHours(Date start, Date end) {
		return (start.getTime() - end.getTime()) / 1000 / 60 / 60;
		
	}

	public int updateById(String reservationId, String roomTypeNo, String name, String phone,
			String arriveTime, String reserveTime, String reservationTime,
			String comment) {
		
		Reservation reservation = mReservationDao.findById(reservationId);
		
		if (reservation == null) {
			return -1;
		}
		
		
		Room room = reservation.getRoom();
		if (room.getRoomTypeNo() != Integer.parseInt(roomTypeNo)) {
			Room newRoom = findFreeRoom(roomTypeNo);
			if (newRoom == null) {
				return -1;
			}
			
			reservation.setRoom(newRoom);
			
			newRoom.setStatusReserved();
			mRoomDao.update(newRoom);
			
			room.setStatusFree();
			mRoomDao.update(room);
		}
		
		reservation.setName(name);
		reservation.setPhone(phone);
		reservation.setArriveTime(arriveTime);
		reservation.setReserveTime(reserveTime);
		reservation.setReservationTime(reservationTime);
		reservation.setComment(comment);
		
		mReservationDao.update(reservation);
		
		return 0;
	}

	//查询预订信息
	public List<Reservation> findAllReservation(String name, String phone,String arriveTime){
		ReservationDAO reservation = new ReservationDAO();
		return reservation.findAllReservation(name, phone, arriveTime);
	}

}
