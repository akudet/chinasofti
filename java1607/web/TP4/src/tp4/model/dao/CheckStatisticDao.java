package tp4.model.dao;

import java.sql.*;
import java.util.*;

import tp4.model.db.DBConnection;
import tp4.model.vo.CheckStatistic;

/**
 * 
 * @author 巫金桐
 *
 */
public class CheckStatisticDao {
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

	public List<CheckStatistic> findAllCheckinStatistic() {
		String sql = "select count(*) as count, date(checkin_time) as date FROM checkin group by date(checkin_time) order by date asc;";
		return queryAll(sql);
	}
	
	public List<CheckStatistic> findAllCheckoutStatistic() {
		String sql = "select count(*) as count, date(checkout_time) as date FROM checkout group by date(checkout_time) order by date asc;";
		return queryAll(sql);
	}
}
