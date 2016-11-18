package team4.proj1.model.dao.hb.check;

import org.springframework.context.ApplicationContext;

import team4.proj1.model.dao.hb.util.TestUtil;
import team4.proj1.model.dao.include.check.CheckinDAO;
import team4.proj1.model.vo.check.Checkin;

public class CheckinDAOTest {
		public static void main(String[] args) {
			ApplicationContext context = TestUtil.getContext();
			CheckinDAO cd = context.getBean(CheckinDAO.class);
			for(Checkin checkin : cd.findAll()) {
				System.out.println(checkin);
			}
		}
}
