package tp4.model.test;

import tp4.model.dao.UserDao;

/**
 * 
 * @author 马厦林
 *
 */
public class UserDaoTest {
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
		System.out.println(dao.seekAll());
	
	}
}
