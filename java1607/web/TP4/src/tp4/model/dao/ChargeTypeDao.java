package tp4.model.dao;

import java.util.*;

import tp4.model.vo.ChargeType;

public class ChargeTypeDao extends DAO<ChargeType> {

	private static final List<ChargeType> mChargeTypes;

	static {
		mChargeTypes = new ArrayList<ChargeType>();
		mChargeTypes.add(new ChargeType(0, "标准"));
		mChargeTypes.add(new ChargeType(1, "钟点房"));
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
