package test.model.dao.jdbc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp1.model.dao.abst.jdbc.db.DBConnection;
import tp1.model.dao.impl.jdbc.ReservationDAO;
import tp1.model.vo.check.Reservation;

public class DateTest {
	
	public static String cSql(String name, String phone,String arriveTime){
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
			conds.add(" arrive_time like '" + arriveTime + "' ");
		}
		
		String cond = join(conds);
		sql = "SELECT * FROM reservation WHERE " + cond;
		return sql;
	}
	
	
	private static String join(List<String> args) {
		String result = "";
		if (args.size() == 0) {
			return result;
		}
		
		result = args.get(0);
		
		for (int i = 1; i < args.size(); i++) {
			result += " AND " + args.get(i);
		}
		return result;
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1111");
		list.add("2222");
		list.add("3333");
		
		System.out.println(cSql("", "sss", "2016"));
		
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		Date start = null;
		Date end = null;
		try {
			start = df.parse(df.format(now));
			end = df.parse(df.format(start.getTime()+48*60*60*1000));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}
}
