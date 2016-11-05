package test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tp1.model.dao.CheckinDAO;
import tp1.model.dao.CusInfoDAO;
import tp1.model.dao.RoomDAO;
import tp1.model.vo.CusInfo;
import tp1.model.vo.Room;
import tp1.model.vo.RoomType;
import tp1.service.CheckinService;

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
		Room room = new RoomDAO().findById("1000");
		CheckinService service = new CheckinService();
		
		new CheckinDAO().deleteAll();
		
		room.setStatusFree();
		
		RoomDAO roomDao = new RoomDAO();
		roomDao.update(room);
		
		CusInfoDAO cusInfoDao = new CusInfoDAO();
		CusInfo cusInfo = cusInfoDao.findById("1000");
		cusInfoDao.deleteById("1000");

		
		service.checkin(room.getRoomId(), cusInfo, "" + RoomType.NORMAL_ROOM, "" + 10, "" + 10, null);
		
	}

}
