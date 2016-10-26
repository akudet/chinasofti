package tp1.model.test;

import tp1.model.dao.VipDAO;
import tp1.model.vo.Vip;

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
