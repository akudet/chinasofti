package team4.proj1.model.dao.hb.cus;

import org.springframework.context.ApplicationContext;

import team4.proj1.model.dao.hb.util.TestUtil;
import team4.proj1.model.dao.include.cus.CusTypeDAO;
import team4.proj1.model.vo.cus.CusType;

public class CusTypeDAOTest {
	public static void main(String[] args) {
		ApplicationContext context = TestUtil.getContext();
		CusTypeDAO ctd = context.getBean(CusTypeDAO.class);
		CusType ct = new CusType();
		ct.setCusTypeDesc("Priminum");
		ct.setDiscount(7);
		ctd.add(ct);
		System.out.println(ctd.findAll());
	}
}
