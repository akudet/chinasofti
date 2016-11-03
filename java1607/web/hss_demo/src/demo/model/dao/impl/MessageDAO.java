package demo.model.dao.impl;

import demo.model.dao.abst.AbstractDAO;
import demo.model.vo.Message;

public class MessageDAO extends AbstractDAO<Message> {
	
	public MessageDAO() {
		super(Message.class);
	}

}
