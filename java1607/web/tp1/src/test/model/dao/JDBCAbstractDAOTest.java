package test.model.dao;

import java.util.List;

import tp1.model.dao.JDBCAbstractDAO;
import tp1.model.dao.impl.jdbc.mapper.impl.VipMapper;
import tp1.model.vo.cus.Vip;

public class JDBCAbstractDAOTest {
	
	private JDBCAbstractDAO<Vip> vd = new JDBCAbstractDAO<Vip>(new VipMapper(), "vip");
	
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
