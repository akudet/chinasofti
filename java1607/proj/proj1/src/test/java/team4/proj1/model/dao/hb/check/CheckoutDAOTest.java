package team4.proj1.model.dao.hb.check;

import team4.proj1.model.dao.hb.AbstractDAOTest;
import team4.proj1.model.dao.include.check.CheckoutDAO;
import team4.proj1.model.vo.check.Checkout;

public class CheckoutDAOTest extends AbstractDAOTest<Checkout> {
	public CheckoutDAOTest() {
		super(CheckoutDAO.class);
	}

	public static void main(String[] args) {
		CheckinDAOTest test = new CheckinDAOTest();
		test.findAllTest();
	}
}
