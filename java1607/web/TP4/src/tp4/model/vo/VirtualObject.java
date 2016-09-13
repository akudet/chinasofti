package tp4.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class VirtualObject {
	
	private static int mMagic = 1;
	private static final Map<Integer, String> mMagicTable = new HashMap<Integer, String>();
	
	protected static int regMsg(String msg) {
		int magic = mMagic;
		mMagicTable.put(mMagic++, msg);
		return magic;
	}
	
	protected String getMsg(int magic) {
		;return mMagicTable.get(magic);
	}

	// using the @rs to setup object's fields
	public abstract void map(ResultSet rs) throws SQLException;
	
	public String randomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
