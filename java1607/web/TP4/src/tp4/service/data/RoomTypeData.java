package tp4.service.data;

import tp4.service.RoomTypeService;

public class RoomTypeData extends Data {
	RoomTypeService service = new RoomTypeService();
	
	
	public void addData() {
		service.add(0, "标准单人间", 12, 11, false, 0, "ni hao a!");
	}
	
}
