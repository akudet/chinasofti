package demo.model.dao.impl;

import demo.model.dao.abst.AbstractDAO;
import demo.model.vo.Room;

public class RoomDAO extends AbstractDAO<Room> {

	public RoomDAO() {
		super(Room.class);
	}

}
