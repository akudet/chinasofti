package team4.proj1.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import team4.proj1.model.dao.impl.jdbc.CusInfoDAO;
import team4.proj1.model.dao.impl.jdbc.RoomDAOImpl;
import team4.proj1.model.dao.impl.jdbc.check.CheckinDAOImpl;
import team4.proj1.model.vo.cus.CusInfo;
import team4.proj1.model.vo.room.Room;
import team4.proj1.model.vo.room.RoomType;
import team4.proj1.service.CheckinService;

public class CheckinServiceTest {
	


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void checkinTest() {
		Room room = new RoomDAOImpl().findOneByRoomId("1000");
		CheckinService service = new CheckinService();
		
		room.setStatusFree();
		
		RoomDAOImpl roomDao = new RoomDAOImpl();
		roomDao.update(room);
		
		CusInfoDAO cusInfoDao = new CusInfoDAO();
		CusInfo cusInfo = cusInfoDao.findById("1000");
		cusInfoDao.deleteById("1000");

		
		service.checkin(room.getRoomId(), cusInfo, "" + RoomType.NORMAL_ROOM, "" + 10, "" + 10, null);
		
	}

}
