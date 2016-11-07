package tp1.model.dao.abst.jdbc.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface JDBCWork<T> {
	
	public T execute(PreparedStatement ps) throws SQLException;
	
}
