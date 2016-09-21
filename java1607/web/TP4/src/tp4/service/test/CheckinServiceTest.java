package tp4.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tp4.model.dao.CheckinDao;
import tp4.model.dao.CusInfoDao;
import tp4.model.dao.RoomDao;
import tp4.model.vo.CusInfo;
import tp4.model.vo.Room;
import tp4.model.vo.RoomType;
import tp4.service.CheckinService;

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
		Room room = new RoomDao().findById("1000");
		CheckinService service = new CheckinService();
		
		new CheckinDao().deleteAll();
		
		room.setStatusFree();
		
		RoomDao roomDao = new RoomDao();
		roomDao.update(room);
		
		CusInfoDao cusInfoDao = new CusInfoDao();
		CusInfo cusInfo = cusInfoDao.findById("1000");
		cusInfoDao.deleteById("1000");

		
		service.checkin(room.getRoomId(), cusInfo, "" + RoomType.NORMAL_ROOM, "" + 10, "" + 10);
		
	}

}
