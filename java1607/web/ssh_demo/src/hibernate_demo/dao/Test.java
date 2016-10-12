package hibernate_demo.dao;

import java.util.Iterator;

import hibernate_demo.vo.Address;
import hibernate_demo.vo.Message;
import hibernate_demo.vo.User;

public class Test {
	public static void main(String[] args) {

		UserDao ud = new UserDao();
		MessageDao md = new MessageDao();
		AddressDao ad = new AddressDao();
		
		int id = (Integer) md.add(new Message("ASDASDAS"));
		
		Message m = md.find(id);
		
		m = new Message();
		m.setId(id);
		
		// add many users refer to the the message
		addUsers(m);
		
		Address addr1 = new Address();
		
		addr1.setLine_1("Beijing");
		addr1.setLine_2("ZhaoYang");
		
		ad.add(addr1);
		
		Iterator<User> iter = ud.findAll("From User").iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	private static void addUsers(Message m) {
		UserDao ud = new UserDao();
		
		User u1 = new User();
		User u2 = new User();
		
		u1.setName("jtwu");
		u1.setAge(10);
		u1.setMessage(m);

		u2.setName("kyo");
		u2.setAge(17);
		u2.setMessage(m);
		
		ud.add(u1);
		ud.add(u2);
	}
}
