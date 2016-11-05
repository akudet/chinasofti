package tp1.model.dao;

import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {

	private static final int PAGE_COUNT = 10;

	public abstract List<T> findAll();

	public List<T> findAll(int pageNo) {
		return null;
	}

	public List<T> findAll(String query, Object... params) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
}
