package tp4.model.db.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import tp4.model.db.DBConnection;

public class TestData {
	private Connection conn;
	private Random rgen;
	private DateFormat dateFormatter;

	public void addBillData() throws SQLException {
		final int NUM_OF_ITEM = 10;
		final String INSERT_TMPL = "INSERT INTO bill VALUES('%s', %f, '%s', '%s');";
		
		conn.prepareStatement("DELETE FROM bill;").execute();
		
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			String sql = String.format(INSERT_TMPL,
					UUID.randomUUID().toString().replace("-", ""),
					rgen.nextFloat() * 1000,
					dateFormatter.format(new Date()),
					"this is a comment");
			System.out.println(sql);
			conn.prepareStatement(sql).execute();
		}
	}
	
	public static void main(String[] args) {
		TestData test = new TestData(DBConnection.getConnection(),
				new Random(), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
		try {
			test.addBillData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TestData(Connection conn, Random rgen, DateFormat dateFormatter) {
		super();
		this.conn = conn;
		this.rgen = rgen;
		this.dateFormatter = dateFormatter;
	}
}
