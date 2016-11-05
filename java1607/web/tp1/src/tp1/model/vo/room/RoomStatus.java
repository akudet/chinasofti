package tp1.model.vo.room;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp1.model.vo.ValueObject;

public class RoomStatus extends ValueObject {
	
	private int roomStatusNo;
	private String roomStatusDesc;

	public RoomStatus(int roomStatusNo, String roomStatusDesc) {
		super();
		this.roomStatusNo = roomStatusNo;
		this.roomStatusDesc = roomStatusDesc;
	}

	public String getRoomStatusDesc() {
		return roomStatusDesc;
	}

	public int getRoomStatusNo() {
		return roomStatusNo;
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
