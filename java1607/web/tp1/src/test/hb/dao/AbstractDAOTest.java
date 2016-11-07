package test.hb.dao;

import java.util.*;

import test.hb.model.dao.impl.*;
import test.hb.model.vo.*;

public class AbstractDAOTest {
	public static void main(String[] args) {

		UserDAO ud = new UserDAO();
		MessageDAO md = new MessageDAO();
		
		int id = (Integer) md.add(new Message("ASDASDAS"));
		
		Message m = md.find(id);
		
		m = new Message();
		m.setId(id);
		
		// add many users refer to the the message
		addUsers(m);
		
		User ub = ud.find(1);
		
		RoomDAO rd = new RoomDAO();
		
		Room r1 = new Room();
		r1.setName("SADA");
		r1.setUsers(new HashSet<User>(ud.findAll()));
		
		rd.add(r1);
		
		User ua = ud.find(1);
		
		List<Room> rooms = rd.findAll();
		
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
		UserDAO ud = new UserDAO();
		
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
