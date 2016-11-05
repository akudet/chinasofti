package test.model.test;

import tp1.model.dao.impl.jdbc.VipDAO;
import tp1.model.vo.cus.Vip;

/**
 *
 * @author 马厦伟
 *
 */
public class VipDaoTest {	
	
	public static void main(String[] args) {
		Vip vip = new VipDAO().findById("1000");
		System.out.println(vip.toXML());
	}
}
