package team4.proj1.model.dao.include.check;

import java.util.List;

import team4.proj1.model.dao.include.DAO;
import team4.proj1.model.vo.check.Checkin;

public interface CheckinDAO extends DAO<Checkin> {

	public int deleteById(String checkinId);

	public List<Checkin> findAll(int checkinType, int checkinStatus);

	public List<Checkin> findAllByCheckinStatus(int checkinStatus);

	public List<Checkin> findAllByCus(String name, String roomId,
			String cusTypeNo);

	public Checkin findById(String checkinId);

	public Checkin findUncheckByRoomId(String roomId);

}
