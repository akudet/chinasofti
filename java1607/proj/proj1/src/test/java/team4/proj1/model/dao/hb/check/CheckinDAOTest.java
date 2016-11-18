package team4.proj1.model.dao.hb.check;

import team4.proj1.model.dao.hb.AbstractDAOTest;
import team4.proj1.model.dao.include.check.CheckinDAO;
import team4.proj1.model.vo.check.Checkin;

public class CheckinDAOTest extends AbstractDAOTest<Checkin> {
	public CheckinDAOTest() {
		super(CheckinDAO.class);
	}

	public static void main(String[] args) {
		CheckinDAOTest test = new CheckinDAOTest();
		test.findAllTest();
	}
}
