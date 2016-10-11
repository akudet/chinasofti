package hibernate_demo.dao;

import java.util.List;

import org.hibernate.Session;

import hibernate_demo.db.DBHelper;
import hibernate_demo.db.TransactionWork;
import hibernate_demo.vo.Message;

public class MessageDao extends AbstractDao<Message> {
	
	public MessageDao() {
		super(Message.class);
	}

	public static void main(String[] args) {
		
		MessageDao dao = new MessageDao();
		dao.add(new Message(1, "DSFS"));
		dao.add(new Message(1, "SDFS"));
		
		Message m = dao.find(1);
		m.setText("I love hibernate");
		dao.update(m);
		
		List<Message> messages = dao.findAll("FROM Message");
		
		for (Message message : messages) {
			System.out.println(message);
		}
		
	}

}
