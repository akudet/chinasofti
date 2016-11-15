package team4.proj1.model.vo.check;

import java.sql.ResultSet;
import java.sql.SQLException;

import team4.proj1.model.vo.ValueObject;

public class CheckStatistic extends ValueObject {

	private int count;
	private String date;

	public int getCount() {
		return count;
	}

	public String getDate() {
		return date;
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		this.count = rs.getInt("count");
		this.date = rs.getString("date");
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CheckStatistic [count=" + count + ", date=" + date + "]";
	}

}
