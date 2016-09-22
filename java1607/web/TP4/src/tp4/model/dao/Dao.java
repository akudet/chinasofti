package tp4.model.dao;

import java.util.List;

public abstract class DAO<T> {

	public abstract int add(T t);

	public abstract int deleteAll();

	public abstract int deleteById(String id);

	public abstract List<T> findAll();

	public abstract T findById(String id);

	public abstract int update(T t);
	
	public List<T> findAll(int pageNo) {
		return null;
	}
	
	public int getTotalPage() {
		return 0;
	}
	
	//查询预订信息调用方法
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
