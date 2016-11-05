package test.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tp1.model.dao.JDBCAbstractDAO;
import tp1.model.dao.Mapper;
import tp1.model.vo.cus.Vip;

public class JDBCAbstractDAOTest {
	
	private JDBCAbstractDAO<Vip> vd = new JDBCAbstractDAO<Vip>(new Mapper<Vip>() {

		@Override
		public Vip map(ResultSet rs) throws SQLException {
			Vip vip = new Vip();
			vip.setVipNo(rs.getInt("vip_no"));
			return vip;
		}
		
	}, "vip");
	
	public void findAllTest() {
		List<Vip> vips = vd.findAll();
		
		for (Vip vip : vips) {
			System.out.println(vip.getVipNo());
		}
	}
	
	public void run() {
		findAllTest();
		System.out.println(vd.getTotalPage());
	}
	
	public static void main(String[] args) {
		JDBCAbstractDAOTest test = new JDBCAbstractDAOTest();
		test.run();
	}

}
