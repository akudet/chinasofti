package team4.proj2.model.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team4.proj2.config.AppConfig;
import team4.proj2.model.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class UserDAOTest {

	@Resource
	UserDAO ud;

	@Test
	public void test() {
		User u = new User();
		u.setName("jtwu");
		u.setAge(10);
		ud.insert(u);
		assertEquals(ud.findAll().size(), 1);

		u = ud.findOneByName("jtwu");
		assertEquals(u.getName(), "jtwu");

		ud.delete(u);
		assertEquals(ud.findAll().size(), 0);
	}

}
