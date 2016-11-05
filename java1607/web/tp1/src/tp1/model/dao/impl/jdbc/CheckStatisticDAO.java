package tp1.model.dao.impl.jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import tp1.model.dao.impl.jdbc.db.DBConnection;
import tp1.model.vo.check.CheckStatistic;

/**
 * 
 * @author 巫金桐
 *
 */
public class CheckStatisticDAO {
	private List<CheckStatistic> queryAll(String sql) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			
			ArrayList<CheckStatistic> list = new ArrayList<CheckStatistic>();
			while (res.next()) {
				CheckStatistic statistic = new CheckStatistic();
				statistic.map(res);
				list.add(statistic);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// not reach here
		return null;
	}

	public List<CheckStatistic> findAllCheckinStatistic(String start, String end) {
		String having = "having date between '" + start + "' and '" + end + "'";
		String sql = "select count(*) as count, date(checkin_time) as date FROM checkin group by date(checkin_time) " + having + " order by date asc;";
		System.out.println(sql);
		return queryAll(sql);
	}
	
	public List<CheckStatistic> findAllCheckoutStatistic(String start, String end) {
		String having = "having date between '" + start + "' and '" + end + "'";
		String sql = "select count(*) as count, date(checkout_time) as date FROM checkout group by date(checkout_time) " + having + "  order by date asc;";
		return queryAll(sql);
	}
	
	public static void main(String[] args) {
		CheckStatisticDAO mCSD = new CheckStatisticDAO();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String end = df.format(now);
		String start = df.format(new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000));
		
		List<CheckStatistic> statistics = mCSD.findAllCheckinStatistic(start, end);
		System.out.println(statistics);
	}
}
