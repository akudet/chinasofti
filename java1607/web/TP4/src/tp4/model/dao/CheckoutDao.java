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

/**
 * 
 * @author 田霞光
 * 
 */
public class CheckoutDao {

	// checkout表的添加
	public int add(Checkout checkout) {
		Connection con = DBConnection.getConnection();
		String sql = "insert into checkout values(?,?,?,?,NULL)";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		String now1 = sdf1.format(date);
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, "out" + now);
			pre.setFloat(2, checkout.getCheckoutAmount());
			pre.setString(3, now1);
			pre.setString(4, checkout.getComment());
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

	// checkout表的删除，根据checkout_id
	public int deleteById(String checkoutId) {

		Connection con = DBConnection.getConnection();
		String sql = "delete from checkout where checkout_id = ?";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkoutId);
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

	// checkout表的全查询
	public ArrayList<Checkout> findAll() {

		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from checkout";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<Checkout> list = new ArrayList<Checkout>();
			while (res.next()) {

				Checkout user = new Checkout(res.getString("checkout_id"),
						res.getFloat("checkout_amount"),
						res.getString("checkout_time"),
						res.getString("comment"));
				user.setCheckin(new CheckinDao().findById(res.getString("checkin_id")));
				list.add(user);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// checkout表根据id查询 0
	public Checkout findById(String checkoutid) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from checkout where checkout_id=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkoutid);
			res = pre.executeQuery();
			if (res.next()) {
				Checkout checkout = new Checkout(res.getString("checkout_id"),
						res.getFloat("checkout_amount"),
						res.getString("checkout_time"),
						res.getString("comment"));
				return checkout;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	//checkout表根据时间范围查询
	public ArrayList<Checkout> findByTime(Date start,Date end){
		SimpleDateFormat fm = null ;
		String start_date = fm.format(start);
		String end_date = fm.format(end);
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		ArrayList<Checkout> list = new ArrayList<Checkout>();
		String sql = "select * from checkout where checkout_time between ? and ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, start_date);
			pre.setString(1, end_date);
			res = pre.executeQuery();
			while (res.next()) {
				CheckinDao dao = new CheckinDao();
				Checkin checkin = dao.findById(res.getString("checkin_id"));
				Checkout checkOut = new Checkout(res.getString("checkout_id"),
						res.getFloat("checkout_amount"),
						res.getString("checkout_time"),
						res.getString("comment"), checkin);
				list.add(checkOut);
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

	//checkout表根据计费类型和房间类型以及时间查询
		//生成查询sql; 0表示全部，1表示标准，2表示钟点房
		private String getSql(Date start, Date end, int checkType, List<Integer> roomTypeNos){
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			String checkTypeCond = "";
			if (checkType == 1) {
				checkTypeCond = "checkin_type like '标准'";
			} else if (checkType == 2) {
				checkTypeCond = "checkin_type like '钟点房'";
			}
			String roomTypeCond = "";
			if (roomTypeNos.size() > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append("room_type_no in (");
				for (Integer roomTypeNo : roomTypeNos) {
					sb.append(roomTypeNo + ", ");
				}
				sb.append("-1)");
				roomTypeCond = sb.toString();
			}
			String dateCond = " date(checkout_time) between '" + fm.format(start) + "' AND '" + fm.format(end) + "'";
			String sql = "select * from checkout, checkin, room where checkout.checkin_id = checkin.checkin_id and checkin.room_id = room.room_id and " + checkTypeCond + " and " + roomTypeCond + " and " + dateCond;
			return sql;
		}
	public ArrayList<Checkout> find(Date start, Date end, int checkType, List<Integer> roomTypeNos){
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = getSql(start, end, checkType, roomTypeNos);
		ArrayList<Checkout> list = new ArrayList<Checkout>();
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Checkout co = new Checkout(res.getString("checkout_id"),
						res.getFloat("checkout_amount"),
						res.getString("checkout_time"),
						res.getString("comment"));
				String checkinId = res.getString("checkin_id");
				Checkin checkin = new CheckinDao().findById(checkinId);
				co.setCheckin(checkin);
				list.add(co);
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
	// checkType 0 全部 1 标准 2 钟点房
	
	// checkout表根据客户姓名、客户类型、房间号和当前状态查询
	public ArrayList<Checkout> find(String name, String roomId, String status,
			String cusTypeDesc){
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		ArrayList<Checkout> list = new ArrayList<Checkout>();
		String sql = "select * from checkout,cus_info,cus_type,room where cus_info.name = ? and room.room_id=? and room.status=? and cus_type_desc = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, roomId);
			pre.setString(3, status);
			pre.setString(4, cusTypeDesc);
			res = pre.executeQuery();
			while(res.next()){
				Checkout co = new Checkout(res.getString("checkout_id"),
						res.getFloat("checkout_amount"),
						res.getString("checkout_time"),
						res.getString("comment"));
				String checkinId = res.getString("checkin_id");
				Checkin checkin = new CheckinDao().findById(checkinId);
				co.setCheckin(checkin);
				list.add(co);
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
	// checkout表的修改
	public int update(Checkout checkout) {
		Connection con = DBConnection.getConnection();
		String sql = "update person set checkout_amount=?,comment=? where checkout_id= ? ";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkout.getCheckoutId());
			pre.setFloat(2, checkout.getCheckoutAmount());
			pre.setString(3, checkout.getComment());

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

}
