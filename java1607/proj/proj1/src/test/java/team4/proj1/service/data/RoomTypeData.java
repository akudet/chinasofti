package team4.proj1.service.data;

import team4.proj1.service.impl.admin.RoomTypeServiceImpl;

public class RoomTypeData extends Data {
	RoomTypeServiceImpl service = new RoomTypeServiceImpl();
	
	
	public void addData() {
		service.add(0, "标准单人间", 12, 11, false, 0, "ni hao a!");
	}
	
}
