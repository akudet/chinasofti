package ex12;

import java.util.*;

public class Main {
	private static List<User> users = new ArrayList<User>(5);
	
	

	public static void main(String[] args) {
		addUsers();

		User user = login();
		
		if (null == user) {
			System.out.println("Login failed: system shutting down");
			System.exit(-1);
		} else {
			System.out.println("Welcome " + user.getName());
		}

	}

	private static void addUsers() {
		users.add(new User("jtwu", "123"));
		users.add(new User("zaft", "321"));
		users.add(new User("narukami", "222"));
		users.add(new User("kugimi", "222"));
		users.add(new User("tiger", "222"));
		users.add(new User("ÇÍ±Ú", "222"));
		users.add(new User("ÑùÊ½", "222"));
	}

	private static User login() {
		Scanner scan = new Scanner(System.in);
		
		for (int i = 3; i > 0; i--) {
			System.out.print("Please enter username : ");
			System.out.flush();
			
			String name = null;
			if (scan.hasNext()) {
				name = scan.next();
			} else {
				System.exit(0);
			}
			
			System.out.print("Please enter passwaord : ");
			System.out.flush();
			
			String password = null;
			if (scan.hasNext()) {
				password = scan.next();
			} else {
				System.exit(0);
			}
			
			// check whether there got a match for the user
			User user = new User(name, password);
			int index = users.indexOf(user);
			if (-1 == index) {
				System.out.println("Wrong username or password");
				System.out.println("Please Reatry, you have " + (i - 1)+ " time(s) remains");
			} else {
				return users.get(index);
			}
		}
		
		return null;
	}

	private static User findUserByName(String name, List<User> users) {
		for (User user : users) {
			if (name.equals(user.getName())) {
				return user;
			}
		}
		return null;
	}
	
}
