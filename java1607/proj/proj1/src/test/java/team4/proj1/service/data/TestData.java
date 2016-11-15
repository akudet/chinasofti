package team4.proj1.service.data;

import java.util.*;

public class TestData {
	
	public static void main(String[] args) {
		List<Data> datas = new ArrayList<Data>();
		datas.add(new UserData());
		datas.add(new RoomTypeData());
		
		for (Data data : datas) {
			data.addData();
		}
	}

}
