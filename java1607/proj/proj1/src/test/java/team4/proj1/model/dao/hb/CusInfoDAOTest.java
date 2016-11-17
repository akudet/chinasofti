package team4.proj1.model.dao.hb;

import org.springframework.context.ApplicationContext;

import team4.proj1.model.dao.hb.util.TestUtil;
import team4.proj1.model.dao.include.cus.CusInfoDAO;
import team4.proj1.model.vo.cus.CusInfo;

public class CusInfoDAOTest {
	public static void main(String[] args) {
		ApplicationContext context = TestUtil.getContext();
		CusInfoDAO cid = context.getBean(CusInfoDAO.class);
		CusInfo ci = new CusInfo();
		ci.setName("jtwu");
		ci.setPhone("17768100357");
		cid.add(ci);
		System.out.println(cid.findAll());
	}
}
