package team4.proj1.model.dao.hb.cus;

import org.springframework.context.ApplicationContext;

import team4.proj1.model.dao.hb.util.TestUtil;
import team4.proj1.model.dao.include.cus.VipDAO;
import team4.proj1.model.vo.cus.Vip;

public class VipDAOTest {

	public static void main(String[] args) {
		ApplicationContext context = TestUtil.getContext();
		VipDAO vd = context.getBean(VipDAO.class);
		System.out.println(vd.findAll());
		Vip vip = new Vip();
		vip.setVipNo(10);
		vd.add(vip);
		System.out.println(vd.findAll());
	}
	
}
