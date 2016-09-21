package tp4.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp4.model.dao.ReservationDao;
import tp4.model.dao.RoomDao;
import tp4.model.vo.Reservation;
import tp4.model.vo.Room;

/**
 * 
 * @author 巫金桐
 * 
 */
public class ReservationService {
	
	private final ReservationDao mReservationDao;
	private final RoomDao mRoomDao;

	public ReservationService() {
		super();
		this.mRoomDao = new RoomDao();
		this.mReservationDao = new ReservationDao();
	}
	
	public int deleteById(String reservationId) {
		ReservationDao Res = new ReservationDao();
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
			String arriveTime, String reserveTime,
			String reservationTime, String comment) {

		
		Room room = findFreeRoom(roomTypeNo);
		if (room == null) {
			throw new ReservationServiceException("没有空闲房间");
		}
		room.setStatusReserved();
		mRoomDao.update(room);
		
		Reservation reservation = new Reservation();
		
		if (name.equals("") || phone.equals("")) {
			throw new ReservationServiceException("姓名和电话必须都不为空");
		}
		
		reservation.setName(name);
		reservation.setPhone(phone);
		reservation.setArriveTime(arriveTime);
		reservation.setReserveTime(reserveTime);
		reservation.setReservationTime(reservationTime);
		reservation.setComment(comment);

		reservation.setRoom(room);
		
		try {
			mReservationDao.add(reservation);
		} catch (SQLException e) {
			// TODO : come up with a better way to do this
			// this is not right
			throw new ReservationServiceException("时间格式错误");
		}
		
		return reservation;
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
		ReservationDao reservation = new ReservationDao();
		return reservation.findAllReservation(name, phone, arriveTime);
	}

}
