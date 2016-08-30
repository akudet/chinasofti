package jtwu.model;

import java.util.HashMap;
import java.util.Map;

/** 
 * class used to generate some facked user data
 * @author Administrator
 *
 */
public class UserData {

	public static Map<String, User> createUsers() {
		Map<String, User> users = new HashMap<String, User>();
		
		users.put("jtwu", new User("jtwu", "jtwu", User.AUTH_SUCC));
		users.put("jtwu1", new User("jtwu1", "jtwu", User.ERR_AUTH_REJECT));
		users.put("jtwu2", new User("jtwu2", "jtwu", User.ERR_PENDING_AUTH));
		
		return users;
	}
}
