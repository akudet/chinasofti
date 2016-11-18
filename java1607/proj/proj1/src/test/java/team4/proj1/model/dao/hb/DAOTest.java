package team4.proj1.model.dao.hb;

import java.util.ArrayList;
import java.util.List;

import team4.proj1.model.dao.include.check.CheckoutDAO;
import team4.proj1.model.vo.check.Checkout;

public class DAOTest {
	public static void main(String[] args) {
		List<AbstractDAOTest<?>> tests = new ArrayList<AbstractDAOTest<?>>();

		tests.add(new AbstractDAOTest<Checkout>(CheckoutDAO.class));

		for (AbstractDAOTest<?> test : tests) {
			test.findAllTest();
		}
	}
}
