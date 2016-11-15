package team4.proj1.model.dao.hb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import team4.proj1.model.dao.impl.hb.abst.db.HibernateConfig;
import team4.proj1.model.dao.include.cus.VipDAO;
import team4.proj1.model.vo.cus.Vip;

public class VipDAOTest {

	public static void main(String[] args) {
		//原因是Spring中的cglib-nodep-2.x.x.jar与Hibernate中的cglib-2.2.jar相冲突!
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		VipDAO vd = context.getBean(VipDAO.class);
		System.out.println(vd.findAll());
		Vip vip = new Vip();
		vip.setVipNo(10);
		vd.add(vip);
		System.out.println(vd.findAll());
	}
	
}
