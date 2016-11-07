package tp1.model.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp1.model.dao.impl.jdbc.abst.JDBCAbstractDAO;
import tp1.model.dao.impl.jdbc.abst.db.DBConnection;
import tp1.model.vo.check.Checkin;
import tp1.model.vo.check.Checkout;

/**
 * 
 * @author 田霞光
 * 
 */
public class CheckoutDAO extends JDBCAbstractDAO<Checkout> {

	private static final int PAGE = 5;

	// checkout表的添加
	public int add(Checkout checkout) {
		Connection con = DBConnection.getConnection();
		String sql = "insert into checkout values(?,?,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, checkout.getCheckoutId());
			pre.setFloat(2, checkout.getCheckoutAmount());
			pre.setString(3, checkout.getCheckoutTime());
			pre.setString(4, checkout.getComment());
			pre.setString(5, checkout.getCheckin().getCheckinId());
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
				user.setCheckin(new CheckinDAO().findById(res
						.getString("checkin_id")));
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

	// checkout表根据时间范围查询
	public ArrayList<Checkout> findByTime(Date start, Date end) {
		SimpleDateFormat fm = null;
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
				CheckinDAO dao = new CheckinDAO();
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
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	public ArrayList<Checkout> findByRoom(String start, String end, String checkType,
			List<Integer> roomTypeNos) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;

		List<String> conds = new ArrayList<String>();

		String checkTypeCond = "checkin_type like '%'";
		System.out.println("SADSADSAD : " + checkType);
		if (null != checkType && !checkType.equals("-1")) {
			checkTypeCond = " checkin_type like '" + checkType + "' ";
		}
		conds.add(checkTypeCond);
		
		
		String roomTypeCond = "";
		StringBuilder sb = new StringBuilder();
		sb.append("room_type_no in (");
		for (Integer roomTypeNo : roomTypeNos) {
			sb.append(roomTypeNo + ", ");
		}
		sb.append("-1)");
		roomTypeCond = sb.toString();
		conds.add(roomTypeCond);

		String dateCond = " date(checkout_time) between '" + start + "' AND '" + end + "' ";
		conds.add(dateCond);

		
		String sql = "select * from checkout, checkin, room where checkout.checkin_id = checkin.checkin_id and checkin.room_id = room.room_id AND ";
		sql += join(conds, " AND ");
		
		System.out.println(sql);
		ArrayList<Checkout> list = new ArrayList<Checkout>();
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Checkout co = new Checkout();
				co.map(res);
				String checkinId = res.getString("checkin_id");
				Checkin checkin = new CheckinDAO().findById(checkinId);
				co.setCheckin(checkin);
				list.add(co);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// checkType 0 全部 1 标准 2 钟点房

	// checkout表根据客户姓名、客户类型、房间号和当前状态查询
	public List<Checkout> findByCus(String name, String roomId, String cusTypeNo) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;

		List<String> conds = new ArrayList<String>();

		if (null != name && !name.equals("")) {
			conds.add(" cus_info.name='" + name + "' ");
		}

		if (null != roomId && !roomId.equals("")) {
			conds.add(" checkin.room_id='" + roomId + "' ");
		}

		if (null != cusTypeNo && !cusTypeNo.equals("")) {
			conds.add(" cus_info.cus_type_no='" + cusTypeNo + "' ");
		}

		List<Checkout> list = new ArrayList<Checkout>();
		String sql = "select * from checkout, checkin, cus_info where checkout.checkin_id = checkin.checkin_id and checkin.cus_info_id = cus_info.cus_info_id and ";
		sql += join(conds, " AND ");
		System.out.println("FIND BY CUS : " + sql);
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Checkout co = new Checkout(res.getString("checkout_id"),
						res.getFloat("checkout_amount"),
						res.getString("checkout_time"),
						res.getString("comment"));
				String checkinId = res.getString("checkin_id");
				Checkin checkin = new CheckinDAO().findById(checkinId);
				co.setCheckin(checkin);
				list.add(co);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	// 分页查询
	@Override
	public List<Checkout> findAll(int pageNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		List<Checkout> list = new ArrayList<Checkout>();

		con = DBConnection.getConnection();
		String sql = "select * from checkout limit ?,?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, (pageNo - 1) * PAGE);
			pre.setInt(1, PAGE);
			res = pre.executeQuery();
			while (res.next()) {
				Checkout checkout = new Checkout();
				Checkin checkin = new CheckinDAO().findById(res
						.getString("check_id"));
				checkout.map(res);
				checkout.setCheckin(checkin);
				list.add(checkout);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// 获得总页数
	@Override
	public int getTotalPage() {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		int count = 0;

		con = DBConnection.getConnection();
		String sql = "select count(*) from checkout";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				count = res.getInt(1);
			}
			count = (int) Math.ceil((count + 1.0 - 1.0) / PAGE);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return super.getTotalPage();
	}

}
