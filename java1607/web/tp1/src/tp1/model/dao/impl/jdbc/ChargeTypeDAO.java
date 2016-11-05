package tp1.model.dao.impl.jdbc;

import java.util.*;

import tp1.model.dao.AbstractDAO;
import tp1.model.vo.check.ChargeType;
import tp1.model.vo.room.RoomType;

public class ChargeTypeDAO extends AbstractDAO<ChargeType> {

	private static final List<ChargeType> mChargeTypes;

	static {
		mChargeTypes = new ArrayList<ChargeType>();
		mChargeTypes.add(new ChargeType(RoomType.NORMAL_ROOM, "标准"));
		mChargeTypes.add(new ChargeType(RoomType.HOUR_ROOM, "钟点房"));
	}

	@Override
	public int add(ChargeType t) {
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
	public List<ChargeType> findAll() {
		// TODO a clone is suitable
		return mChargeTypes;
	}

	@Override
	public ChargeType findById(String id) {
		int i = Integer.parseInt(id);
		return mChargeTypes.get(i);
	}

	@Override
	public int update(ChargeType t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
