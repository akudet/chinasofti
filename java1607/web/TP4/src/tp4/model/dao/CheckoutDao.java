package tp4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import tp4.model.db.DBConnection;
import tp4.model.vo.Checkout;

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
