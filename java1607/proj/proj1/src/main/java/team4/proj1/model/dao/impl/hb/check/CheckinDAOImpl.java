package team4.proj1.model.dao.impl.hb.check;

import java.util.List;

import org.springframework.stereotype.Repository;

import team4.proj1.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj1.model.dao.include.check.CheckinDAO;
import team4.proj1.model.vo.check.Checkin;

@Repository
public class CheckinDAOImpl extends SpringAbstractDAO<Checkin> implements CheckinDAO {

	public CheckinDAOImpl() {
		super(Checkin.class);
	}
	
	@Override
	public int deleteById(String checkinId) {
		Checkin checkin = findOne("FROM Checkin WHERE checkinId=?", checkinId);
		delete(checkin);
		return 0;
	}

	@Override
	public List<Checkin> findAll(int checkinType, int status) {
		return findAll("FROM Checkin WHERE checkinType=?, status=", checkinType, status);
	}

	@Override
	public List<Checkin> findAllByCheckinStatus(int checkinStatus) {
		return findAll("FROM Checkin WHERE checkinStatus=?", checkinStatus);
	}

	@Override
	public List<Checkin> findAllByCus(String name, String roomId,
			String cusTypeNo) {
		return findAll("FROM Checkin WHERE name=?, roomId=?, cusTypeNo=?", name, roomId, cusTypeNo);
	}

	@Override
	public Checkin findById(String checkinId) {
		return findOne("FROM Checkin WHERE checkinId=?", checkinId);
	}

	@Override
	public Checkin findUncheckByRoomId(String roomId) {
		return findOne("FROM Checkin WHERE roomId=?, checkinStatus=?", roomId, Checkin.UNCHECK);
	}

	
	
}
