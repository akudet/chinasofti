package tp1.model.dao.impl.jdbc.abst;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
	
	public T map(ResultSet rs) throws SQLException;

}
