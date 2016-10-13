package demo.model.dao.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import demo.model.dao.impl.AddressDao;
import demo.model.dao.impl.MessageDao;
import demo.model.dao.impl.RoomDao;
import demo.model.dao.impl.UserDao;
import demo.model.vo.Address;
import demo.model.vo.Message;
import demo.model.vo.Room;
import demo.model.vo.User;

public class AbstractDAOTest {
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
		
		User ub = ud.find(1);
		
		RoomDao rd = new RoomDao();
		
		Room r1 = new Room();
		r1.setName("SADA");
		r1.setUsers(new HashSet<User>(ud.findAll()));
		
		rd.add(r1);
		
		User ua = ud.find(1);
		
		List<Room> rooms = rd.findAll("FROM Room");
		
		System.out.println(ub);
		System.out.println(ub.getRooms());
		
		System.out.println(ua);
		System.out.println(ua.getRooms());
		
		for (Room room : rooms) {
			System.out.println(room);
			System.out.println(room.getUsers());
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
