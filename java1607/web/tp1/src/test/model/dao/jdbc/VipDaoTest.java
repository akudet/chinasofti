package test.model.dao.jdbc;

import tp1.model.dao.impl.jdbc.VipDAOImpl;
import tp1.model.vo.cus.Vip;

/**
 *
 * @author 马厦伟
 *
 */
public class VipDaoTest {	
	
	public static void main(String[] args) {
		Vip vip = new VipDAOImpl().findOneByVipNo("1000");
		System.out.println(vip.toXML());
	}
}
