package tp4.model.test;

import tp4.model.dao.RoomDao;
import tp4.model.vo.Room;
import tp4.model.vo.RoomType;

public class RoomTest {
	//添加方法测试
	public void addText(){
		RoomDao dao = new RoomDao();
		Room room = new Room("fas", "fds", "s", 2, "dfs");
		RoomType roomType = new RoomType(2, "双人房", 2, 16.8f, 2, 52.0f, "还不错");
		room.setRoomType(roomType);
		dao.add(room);	
	}
	//删除方法测试
	public void deleteTest(){
		String roomId ="fas";
		RoomDao dao = new RoomDao();
		dao.deleteById(roomId);
	}
	//修改测试方法
	public void updateTest(){
		RoomDao dao = new RoomDao();
		Room room =new Room();
		RoomType roomType = new RoomType(2, "双人房", 2, 16.8f, 2, 52.0f, "还不错");
		room.setRoomId("f8cb8ee4457f4081923aeaa1c890e398");
		room.setRoomType(roomType);
		room.setFloor("2");
		room.setPhone("10180");
		room.setStatus(2);
		room.setComment("还可以额");

		dao.update(room);
	}
	//查询单个的测试方法
	public void queryTest(){
		RoomDao dao = new RoomDao();
		String roomid = "f8cb8ee4457f4081923aeaa1c890e398";
		Room a = dao.findById(roomid);
		System.out.println(a.getRoomId()+'\n'+a.getComment()+a.getFloor()+a.getPhone()+a.getRoomType().getBeds()+a.getStatus());
	}
	public void queryAllTest(){
		RoomDao dao = new RoomDao();
		System.out.println(dao.findAll());
	}
public static void main(String[] args) {
	RoomTest rt = new RoomTest();
	rt. queryAllTest();
}
}
