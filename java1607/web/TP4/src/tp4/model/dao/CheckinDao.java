package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp4.model.db.DBConnection;
import tp4.model.vo.Checkin;
import tp4.model.vo.Checkout;
import tp4.model.vo.CusInfo;
import tp4.model.vo.Room;
import tp4.model.vo.RoomType;

/**
 * 
 * @author 田霞光
 * 
 */
public class CheckinDao extends DAO<Checkin> {
	
	// checkin表的添加
	public int add(Checkin checkin) {
		String cus_info_id = checkin.getCusInfo().getCusInfoId();
		String room_id = checkin.getRoom().getRoomId();
		
		Connection con = DBConnection.getConnection();
		String sql = "insert into checkin values(?,?,?,?,?,?,?,?,?)";


		PreparedStatement pre = null;

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkin.getCheckinId());
			pre.setString(2, room_id);
			pre.setString(3, cus_info_id);
			pre.setString(4, checkin.getCheckinTime());
			pre.setInt(5, checkin.getCheckinType());
			pre.setFloat(6, checkin.getPrice());
			pre.setInt(7, checkin.getNumOfDays());
			pre.setFloat(8, checkin.getDeposit());
			pre.setInt(9, checkin.getStatus());
			int i = pre.executeUpdate();
			if (i > 0) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	// checkin表的删除

	public int deleteById(String checkinid) {

		Connection con = DBConnection.getConnection();
		String sql = "delete from checkin where checkin_id = ?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkinid);
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	// checkin表的全查询
	public ArrayList<Checkin> findAll() {

		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from checkin";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<Checkin> list = new ArrayList<Checkin>();
			while (res.next()) {
				CusInfoDao dao = new CusInfoDao();
				RoomDao dao1 = new RoomDao();
				CusInfo cusinfo = dao.findById(res.getString("cus_info_id"));
				Room room = dao1.findById(res.getString("room_id"));
				
				Checkin checkin = new Checkin();
				checkin.map(res);
				checkin.setCusInfo(cusinfo);
				checkin.setRoom(room);
				
				list.add(checkin);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// checkin表单查询
	public Checkin findById(String checkin) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from checkin where checkin_id=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkin);
			res = pre.executeQuery();
			if (res.next()) {
				CusInfoDao dao = new CusInfoDao();
				RoomDao dao1 = new RoomDao();
				CusInfo cusinfo = dao.findById(res.getString("cus_info_id"));
				Room room = dao1.findById(res.getString("room_id"));

				Checkin user = new Checkin();
				
				user.map(res);
				user.setCusInfo(cusinfo);
				user.setRoom(room);
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// checkin表根据roomId查询
	public Checkin findByRoomId(String roomId) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from checkin where room_id=? and status=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, roomId);
			pre.setInt(2, Checkin.UNCHECK);
			res = pre.executeQuery();
			if (res.next()) {
				CusInfoDao dao = new CusInfoDao();
				RoomDao dao1 = new RoomDao();
				CusInfo cusinfo = dao.findById(res.getString("cus_info_id"));
				Room room = dao1.findById(res.getString("room_id"));
				Checkin user = new Checkin();
				
				user.map(res);
				user.setCusInfo(cusinfo);
				user.setRoom(room);
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// checkin修改
	public int update(Checkin checkin) {
		Connection con = DBConnection.getConnection();
		String sql = "update checkin set room_id=?,cus_info_id=?,checkin_time=?,checkin_type=?,price=?,num_of_days=?,deposit=?,status=? where checkin_id=?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkin.getRoom().getRoomId());
			pre.setString(2, checkin.getCusInfo().getCusInfoId());
			pre.setString(3, checkin.getCheckinTime());
			pre.setInt(4, checkin.getCheckinType());
			pre.setFloat(5, checkin.getPrice());
			pre.setInt(6, checkin.getNumOfDays());
			pre.setFloat(7, checkin.getDeposit());
			pre.setInt(8, checkin.getStatus());
			pre.setString(9, checkin.getCheckinId());
			int i = pre.executeUpdate();
			if (i > 0) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//checkin表查询所有可续住房间
	public List<Checkin> findAllRenew(){
		Connection con = DBConnection.getConnection();
		String sql = "select * from checkin where checkin_type = ? and status = ?";
		PreparedStatement pre = null;
		ResultSet res = null;
		List<Checkin> list = new ArrayList<Checkin>();
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, RoomType.NORMAL_ROOM);
			pre.setInt(2, Checkin.UNCHECK);
			res = pre.executeQuery();
			while(res.next()){
				CusInfoDao dao = new CusInfoDao();
				RoomDao dao1 = new RoomDao();
				CusInfo cusinfo = dao.findById(res.getString("cus_info_id"));
				Room room = dao1.findById(res.getString("room_id"));
				
				Checkin checkin = new Checkin();
				checkin.map(res);
				checkin.setCusInfo(cusinfo);
				checkin.setRoom(room);
				
				list.add(checkin);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Checkin> finByCus(String name, String roomId, int cusTypeNo) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		List<Checkin> list = new ArrayList<Checkin>();
		String sql = "select * from checkin, cus_info where checkin.cus_info_id = cus_info.cus_info_id and cus_info.name = ? and checkin.room_id=? and cus_info.cus_type_no = ? and status = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, roomId);
			pre.setInt(3, cusTypeNo);
			pre.setInt(4, Checkin.UNCHECK);
			res = pre.executeQuery();
			while(res.next()){
				Checkin ci = new Checkin();
				ci.map(res);
				ci.setCusInfo(new CusInfoDao().findById(res.getString("cus_info_id")));
				ci.setRoom(new RoomDao().findById(res.getString("room_id")));
				list.add(ci);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre, res);
		}
		return null;
	}

}
