package tp1.model.dao.include.check;

import java.util.List;

import tp1.model.dao.include.DAO;
import tp1.model.vo.check.Checkin;

public interface CheckinDAO extends DAO<Checkin> {
	
	public Checkin findOneByRoomId(String roomId);
	
	public List<Checkin> findAllByCus(String name, String roomId, String cusTypeNo);
	
	public List<Checkin> findAllByCheckinStatus(int checkinStatus);

}
