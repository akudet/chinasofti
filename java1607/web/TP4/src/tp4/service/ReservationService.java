package tp4.service;

import java.util.ArrayList;
import java.util.List;

import tp4.model.dao.ReservationDao;
import tp4.model.vo.Reservation;

/**
 * 
 * @author 范中兴
 * 
 */
public class ReservationService {

	public int add(String reservationId, String name, String phone,
			String roomTypeDesc, String arriveTime, String reserveTime,
			String reservationTime, String comment) {
		Reservation Re = new Reservation(reservationId, name, phone,
				arriveTime, reserveTime, reservationTime, comment);
		ReservationDao Res = new ReservationDao();
		if (Res.findById(reservationId) == null) {
			return -1;
		} else
			return Res.add(Re);

	}

	public int deleteById(String reservationId) {
		ReservationDao Res = new ReservationDao();
		if (Res.findById(reservationId) == null) {
			return -1;
		} else {
			return Res.deleteById(reservationId);
		}
	}

	public ArrayList<Reservation> findByNameAndPhone(String name, String phone) {
		ReservationDao Res = new ReservationDao();
		if (Res.findByNameAndPhone(name, phone) == null) {
			return null;
		} else
			return Res.findAll();
	}

	public int updateById(String reservationId, String name, String phone,
			String arriveTime, String reserveTime, String reservationTime,
			String comment) {
		Reservation Re = new Reservation(reservationId, name, phone,
				arriveTime, reserveTime, reservationTime, comment);
		ReservationDao Res = new ReservationDao();
		if (Res.findById(reservationId) == null) {
			return -1;
		} else {
			Re = Res.findById(reservationId);
			return Res.update(Re);
		}
	}

}
