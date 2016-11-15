package tp1.model.dao.impl.jdbc.abst.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface JDBCWork<T> {
	
	public T execute(PreparedStatement ps) throws SQLException;
	
}
