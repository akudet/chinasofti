package tp1.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import tp1.model.dao.abst.AbstractDAO;
import tp1.model.dao.abst.jdbc.db.DBConnection;
import tp1.model.vo.admin.User;
import tp1.model.vo.check.Reservation;
import tp1.model.vo.room.Room;

/**
 * 
 * @author 范中兴
 * 
 */
public class ReservationDAO extends AbstractDAO<Reservation>{
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;

	// 添加数据
	public int add(Reservation reservation) {
		con = DBConnection.getConnection();
		String sql = "insert into reservation values(?,?,?,?,?,?,?,?)";

		try {
			pre = con.prepareStatement(sql);

			pre.setString(1, reservation.getReservationId());
			pre.setString(2, reservation.getName());
			pre.setString(3, reservation.getPhone());
			pre.setString(4, reservation.getArriveTime());
			pre.setString(5, reservation.getReserveTime());
			pre.setString(6, reservation.getReservationTime());
			pre.setString(7, reservation.getComment());
			pre.setString(8, reservation.getRoom().getRoomId());

			int i = pre.executeUpdate();

			if (i > 0) {
				return i;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	public int addAll(Collection<Reservation> reservations) throws SQLException {
		for (Reservation reservation : reservations) {
			if (0 != add(reservation)) {
				return -1;
			}
		}
		return 0;
	}

	public int deleteAll() {
		con = DBConnection.getConnection();
		String sql = "delete from reservation";

		try {
			pre = con.prepareStatement(sql);
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return 0;
	}

	public int deleteById(String reservationId) {
		con = DBConnection.getConnection();
		String sql = "delete from reservation where reservation_id = ?";

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, reservationId);
			int i = pre.executeUpdate();
			if (i > 0) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return -1;
	}

	// 查询数据
	public ArrayList<Reservation> findAll() {
		con = DBConnection.getConnection();
		String sql = "select * from reservation";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<Reservation> list = new ArrayList<Reservation>();
			while (res.next()) {
				Reservation reservation = new Reservation(
						res.getString("reservation_id"), res.getString("name"),
						res.getString("phone"), res.getString("arrive_time"),
						res.getString("reserve_time"),
						res.getString("reservation_time"),
						res.getString("comment"));

				reservation.setRoom(new RoomDAOImpl().findOneByRoomId(res
						.getString("room_id")));

				list.add(reservation);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}

		return null;

	}

	public Reservation findById(String reservationId) {
		con = DBConnection.getConnection();
		String sql = "select * from reservation where reservation_id=? ";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, reservationId);
			res = pre.executeQuery();
			if (res.next()) {
				Reservation reservation = new Reservation();
				reservation.map(res);
				reservation.setRoom(new RoomDAOImpl().findOneByRoomId(res
						.getString("room_id")));
				return reservation;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// 删除数据
	// 单查询
	public Reservation findByNameAndPhone(String name, String phone) {
		con = DBConnection.getConnection();
		String sql = "select * from reservation where name=?,phone=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, phone);
			res = pre.executeQuery();
			if (res.next()) {
				Reservation reservation = new Reservation(
						res.getString("reservationId"), res.getString("name"),
						res.getString("phone"), res.getString("arriveTime"),
						res.getString("reserveTime"),
						res.getString("reservationTime"),
						res.getString("comment"));
				return reservation;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// 修改
	public int update(Reservation reservation) {
		con = DBConnection.getConnection();
		String sql = "update reservation set name = ?,phone = ?,arrive_time= ?,reserve_time= ?,reservation_time= ?,comment= ?, room_id=?  where reservation_id= ?";
		try {
			pre = con.prepareStatement(sql);

			pre.setString(1, reservation.getName());
			pre.setString(2, reservation.getPhone());
			pre.setString(3, reservation.getArriveTime());
			pre.setString(4, reservation.getReserveTime());
			pre.setString(5, reservation.getReservationTime());
			pre.setString(6, reservation.getComment());
			pre.setString(7, reservation.getRoom().getRoomId());
			pre.setString(8, reservation.getReservationId());

			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return 0;
	}
	

	
	//查询预订信息
	public List<Reservation> findAllReservation(String name, String phone,String arriveTime){
		con = DBConnection.getConnection();
		String sql = null;
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();	
		String start = null;
		String end = null;
		try {
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date today = df.parse(df.format(now));
			start = df2.format(today);
			end = df2.format(df.parse(df.format(today.getTime()+48*60*60*1000)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> conds = new ArrayList<String>();
		if(!name.equals("")){
			conds.add(" name='" + name + "' ");
		}
		if(!phone.equals("")){
			conds.add(" phone='" + phone + "'");
		}
		if(arriveTime.equals("")){
			conds.add(" arrive_time between '" + start + "' and '" + end + "' ");
		} else {
			conds.add(" arrive_time like '" + arriveTime + "%' ");
		}
		
		String cond = join(conds, " AND ");
		sql = "SELECT * FROM reservation WHERE " + cond;
		List<Reservation> list = new ArrayList<Reservation>();
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				Room room = new RoomDAOImpl().findOneByRoomId(res.getString("room_id"));
				Reservation reservation = new Reservation();
				reservation.map(res);
				reservation.setRoom(room);
				list.add(reservation);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
