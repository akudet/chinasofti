package team4.proj1.model.dao.jdbc;

import team4.proj1.model.dao.impl.jdbc.VipDAOImpl;
import team4.proj1.model.vo.cus.Vip;

/**
 *
 * @author 马厦伟
 *
 */
public class VipDAOTest {	
	
	public static void main(String[] args) {
		Vip vip = new VipDAOImpl().findOneByVipNo("1000");
		System.out.println(vip.toXML());
	}
}
