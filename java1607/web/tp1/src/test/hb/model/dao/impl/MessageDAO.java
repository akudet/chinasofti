package test.hb.model.dao.impl;

import test.hb.model.vo.Message;
import tp1.model.dao.abst.hb.AbstractDAO;

public class MessageDAO extends AbstractDAO<Message> {
	
	public MessageDAO() {
		super(Message.class);
	}
	
}
