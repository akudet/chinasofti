package test.hb.dao;

import java.util.List;

import test.hb.model.dao.impl.MessageDAO;
import test.hb.model.vo.Message;

public class MessageDAOTest {
	public static void main(String[] args) {
		MessageDAO dao = new MessageDAO();
		
		dao.add(new Message(1, "DSFS"));
		dao.add(new Message(1, "SDFS"));
		
		Message m = dao.find(1);
		m.setText("I love hibernate");
		dao.update(m);
		
		List<Message> messages = dao.findAll();
		
		for (Message message : messages) {
			System.out.println(message);
		}
		
	}
}
