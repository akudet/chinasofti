package tp1.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tp1.model.dao.impl.jdbc.db.JDBCHelper;

public class JDBCAbstractDAO<T> implements DAO<T> {

	private final String TABLE_NAME;
	private final Mapper<T> mMapper;

	private static final int PAGE_COUNT = 10;

	// TODO : remove this
	public JDBCAbstractDAO() {
		TABLE_NAME = "";
		mMapper = null;
	}

	// need mapper, tablename, can't return other type than T
	public JDBCAbstractDAO(Mapper<T> mapper, String table) {
		this.mMapper = mapper;
		this.TABLE_NAME = table;
	}

	public List<T> findAll() {
		return findAll("SELECT * FROM " + TABLE_NAME);
	}

	public List<T> findAll(int pageNo) {
		String query = "SELECT * FROM " + TABLE_NAME + " LIMITE ?, ?";
		int start = (pageNo - 1) * getPageCount();
		return findAll(query, start, getPageCount());
	}

	public List<T> findAll(String query, Object... params) {
		return JDBCHelper.executeQuery(mMapper, query, params);
	}

	public T findOne(String query, Object... params) {
		List<T> result = findAll(query, params);
		if (0 == result.size()) {
			return null;
		}
		return result.get(0);
	}

	@Override
	public int getPageCount() {
		return PAGE_COUNT;
	}

	@Override
	public int getTotalPage() {
		String sql = "SELECT COUNT(*) FROM " + TABLE_NAME;
		List<Integer> count = JDBCHelper.executeQuery(new Mapper<Integer>() {

			@Override
			public Integer map(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
			
		}, sql);
		return count.get(0);
	}

	// 查询预订信息调用方法
	public String join(List<String> args, String conn) {
		StringBuilder result = new StringBuilder();
		if (args.size() == 0) {
			return result.toString();
		}

		result.append(args.get(0));

		for (int i = 1; i < args.size(); i++) {
			result.append(conn);
			result.append(args.get(i));
		}
		return result.toString();
	}

	@Override
	public int add(T vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(T vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
