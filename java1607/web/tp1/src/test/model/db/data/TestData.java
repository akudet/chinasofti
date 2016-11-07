package test.model.db.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import tp1.model.dao.abst.jdbc.db.DBConnection;

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
					nextId(),
					rgen.nextFloat() * 1000,
					dateFormatter.format(new Date()),
					nextString(19, 66));
			System.out.println(sql);
			conn.prepareStatement(sql).execute();
		}
	}

	public void addCusTypeData() {
		final int NUM_OF_ITEM = 10;
		final String[] cus_type = {"普通客户", "会员", "团体组织", "内部人事", "协议单位"};
		final String INSERT_TMPL = "INSERT INTO cus_type VALUES('%d', '%s', '%d');";

		for (int i = 0; i < cus_type.length; i++) {
			String sql = String.format(INSERT_TMPL,
					i,
					cus_type[i],
					rgen.nextInt(10) + 1
					);
			System.out.println(sql);
			try {
				conn.prepareStatement(sql).execute();
			} catch (SQLException e) {

			}
		}

	}
	
	public void addCusInfoData() throws SQLException {
		final int NUM_OF_ITEM = 10;
		final String[] cert_type = {"身份证", "军官证", "护照", "其他"};
		final String INSERT_TMPL = "INSERT INTO cus_info VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
		final String[] SEX = {"男", "女"};
		
		conn.prepareStatement("DELETE FROM cus_info;").execute();
		
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			String sql = String.format(INSERT_TMPL,
					nextId(),
					choose(cert_type),
					nextString(5, 30),//cert number
					nextString(1, 3),
					nextString(11, 13),//phone
					nextString(20, 30),//address
					choose(SEX),
					1,
					nextString(11,22)
					);
			System.out.println(sql);
			conn.prepareStatement(sql).execute();
		}
	}
	
	public void addRoomTypeData() {
		final String[] room_type = {"标准单人间", "标准双人间", "豪华单人间", "豪华双人间", "商务套房", "总统套房"};
		final String INSERT_TMPL = "INSERT INTO room_type VALUES('%d', '%s', '%d', %f, %d, %f,'%s');";
		
		for (int i = 0; i < room_type.length; i++) {
			String sql = String.format(INSERT_TMPL,
					i,
					room_type[i],
					rgen.nextInt(3) + 1,
					rgen.nextFloat() * 100,
					rgen.nextInt(2),
					rgen.nextFloat() * 10,
					nextString(10, 30)
					);
			System.out.println(sql);
			try {
				conn.prepareStatement(sql).execute();
			} catch (SQLException e) {
				//TODO : better way to do this
			}
		}
	}
	
	public void addRoomData() throws SQLException {
		final int NUM_OF_ITEM = 15;
		final String INSERT_TMPL = "INSERT INTO room VALUES('%s', '%d', '%d', '%s', '%d', '%s')";
		final String[] SEX = {"男", "女"};
		
		conn.prepareStatement("DELETE FROM room;").execute();
		
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			String sql = String.format(INSERT_TMPL,
					nextId(),
					1,
					rgen.nextInt(30) + 2,
					nextNumbers(11),
					0,
					nextString(11,22)
					);
			System.out.println(sql);
			conn.prepareStatement(sql).execute();
		}
	}

	public void addUserData() throws SQLException {
		final int NUM_OF_ITEM = 15;
		final String INSERT_TMPL = "INSERT INTO user VALUES('%s', '%s', '%s', '%d')";
		
		conn.prepareStatement("DELETE FROM user;").execute();
		
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			String sql = String.format(INSERT_TMPL,
					nextId(),
					nextString(5,11),
					nextString(5,16),
					0
					);
			System.out.println(sql);
			conn.prepareStatement(sql).execute();
		}
	}
	
	public static void main(String[] args) {
		TestData test = new TestData(DBConnection.getConnection(),
				new Random(), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
		try {
			test.addBillData();
			test.addCusInfoData();
			test.addCusTypeData();
			test.addRoomTypeData();
			test.addRoomData();
			test.addUserData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String nextNumbers(int len) {
		String chars = "0123456789";
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < len; i++) {
			sb.append(chars.charAt(rgen.nextInt(chars.length())));
		}
		
		return sb.toString();
	}

	private String nextId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	private String nextName() {
		return nextString(5,11);
	}
	
	private String nextPhone() {
		return nextNumbers(13);
	}

	private String nextString(int min, int max) {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sb = new StringBuffer();
		
		int length = rgen.nextInt(max - min) + min;
		
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(rgen.nextInt(chars.length())));
		}
		
		return sb.toString();
	}

	public <T> T choose(T[] objs) {
		return objs[rgen.nextInt(objs.length)];
	}
	
	public TestData(Connection conn, Random rgen, DateFormat dateFormatter) {
		super();
		this.conn = conn;
		this.rgen = rgen;
		this.dateFormatter = dateFormatter;
	}
}
