package tp1.model.dao.abst;

import tp1.model.dao.abst.jdbc.JDBCAbstractDAO;
import tp1.model.dao.abst.jdbc.mapper.Mapper;
import tp1.model.dao.include.DAO;

public class AbstractDAO<T> extends JDBCAbstractDAO<T> implements DAO<T> {
	
	// TODO : remove this
	public AbstractDAO() {
	}

	// need mapper, tablename, can't return other type than T
	public AbstractDAO(Mapper<T> mapper, String table) {
		super(mapper, table);
	}
	
}
