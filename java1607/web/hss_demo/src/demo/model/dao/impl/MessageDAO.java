package demo.model.dao.impl;

import java.util.List;

import demo.model.dao.abst.AbstractDAO;
import demo.model.vo.Message;

public class MessageDAO extends AbstractDAO<Message> {
	
	public MessageDAO() {
		super(Message.class);
	}

	public static void main(String[] args) {
		
		MessageDAO dao = new MessageDAO();
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
