package tp4.model.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import tp4.model.dao.UserDao;
import tp4.model.vo.User;

/**
 * 
 * @author 巫金桐
 *
 */
public class UserDaoTest {

	@Test
	public void addTest() {
		UserDao dao = new UserDao();
		User user = new User("1006", "jtwu", "jtwu", 0);
		dao.add(user);
		assertNotNull(dao.findById(user.getUserId()));
	}

	@Test
	public void deleteAllTest() {
		UserDao dao = new UserDao();
		User user = new User("1006", "jtwu", "jtwu", 0);
		dao.add(user);
		dao.deleteAll();
		assertEquals(dao.findAll().size(), 0);
	}

	@Test
	public void deleteByIdTest() {
		UserDao dao = new UserDao();
		User user = new User("1006", "jtwu", "jtwu", 0);
		dao.add(user);
		dao.deleteById(user.getUserId());
		assertNull(dao.findById(user.getUserId()));
	}

	@Test
	public void duplicateIdTest() {
		UserDao dao = new UserDao();
		dao.deleteAll();

		List<User> users = new ArrayList<User>();

		users.add(new User("1000", "jtwu", "jtwu", 0));
		users.add(new User("1000", "xsj", "xsj", 0));
		users.add(new User("1000", "zkl", "zkl", 0));
		users.add(new User("1000", "fxz", "fxz", 0));
		users.add(new User("1000", "mxw", "mxw", 0));
		users.add(new User("1000", "wjt", "wjt", 0));
		users.add(new User("1000", "txg", "txg", 0));

		dao.addAll(users);

		System.out.println(dao.findAll().size());
		assertTrue(dao.findAll().size() == 1);
	}

	@Test
	public void findByIdTest() {
		UserDao dao = new UserDao();
		User user = new User("1006", "jtwu", "jtwu", 0);
		dao.add(user);
		assertNotNull(dao.findById(user.getUserId()));
	}

	public List<User> getSampleUsers() {
		List<User> users = new ArrayList<User>();

		users.add(new User("1000", "jtwu", "jtwu", 0));
		users.add(new User("1001", "xsj", "xsj", 0));
		users.add(new User("1002", "zkl", "zkl", 0));
		users.add(new User("1003", "fxz", "fxz", 0));
		users.add(new User("1004", "mxw", "mxw", 0));
		users.add(new User("1005", "wjt", "wjt", 0));
		users.add(new User("1006", "txg", "txg", 0));

		return users;
	}

	@Test
	public void uniqueIdTest() {
		UserDao dao = new UserDao();
		List<User> users = getSampleUsers();
		for (User user : getSampleUsers()) {
			dao.add(user);
		}
		assertTrue(dao.findAll().size() == users.size());
	}

}
