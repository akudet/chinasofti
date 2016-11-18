package team4.proj1.model.dao.hb;

import org.springframework.context.ApplicationContext;

import team4.proj1.model.dao.hb.util.TestUtil;
import team4.proj1.model.dao.include.DAO;

public class AbstractDAOTest<T> {
	
	private Class<? extends DAO<T>> mDAO;
	
	public AbstractDAOTest(Class<? extends DAO<T>> testDAO) {
		this.mDAO = testDAO;
	}
	
	public DAO<T> getDAO() {
		ApplicationContext context = TestUtil.getContext();
		return context.getBean(mDAO);
	}
	
	public void findAllTest() {
		for (T t : getDAO().findAll()) {
			System.out.println(t);
		}
	}

}
