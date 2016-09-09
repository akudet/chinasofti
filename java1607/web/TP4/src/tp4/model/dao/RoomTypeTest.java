package tp4.model.dao;

public class RoomTypeTest {

	public static void init() {
		
	}
	
	public void testFindRoomTypeByNo() {
		RoomTypeDao dao = new RoomTypeDao();
		System.out.println(dao.findRoomTypeByNo(1));
		
	}
	
	public static void main(String[] args) {
		init();
	}
}
