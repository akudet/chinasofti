package test.model.dao;

import java.util.List;

import tp1.model.dao.abst.AbstractDAO;
import tp1.model.dao.impl.jdbc.mapper.VipMapper;
import tp1.model.vo.cus.Vip;

public class JDBCAbstractDAOTest {
	
	private AbstractDAO<Vip> vd = new AbstractDAO<Vip>(new VipMapper(), "vip");
	
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
