package tp4.model.test;

import tp4.model.dao.VipDao;
import tp4.model.vo.Vip;

/**
 *
 * @author 马厦伟
 *
 */
public class VipDaoTest {	
	
	public static void main(String[] args) {
		Vip vip = new VipDao().findById("1000");
		System.out.println(vip.toXML());
	}
}
