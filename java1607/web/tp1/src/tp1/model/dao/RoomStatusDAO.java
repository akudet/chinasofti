package tp1.model.dao;

import java.util.*;

import tp1.model.vo.RoomStatus;

public class RoomStatusDAO extends DAO<RoomStatus> {

	private static final List<RoomStatus> mRoomStatuss;

	static {
		mRoomStatuss = new ArrayList<RoomStatus>();
		mRoomStatuss.add(new RoomStatus(0, "可用"));
		mRoomStatuss.add(new RoomStatus(1, "占用"));
		mRoomStatuss.add(new RoomStatus(2, "停用"));
	}

	@Override
	public int add(RoomStatus t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoomStatus> findAll() {
		return mRoomStatuss;
	}

	@Override
	public RoomStatus findById(String id) {
		int i = Integer.parseInt(id);
		return mRoomStatuss.get(i);
	}

	@Override
	public int update(RoomStatus t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
