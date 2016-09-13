package tp4.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public abstract class VirtualObject {

	// using the @rs to setup object's fields
	public abstract void map(ResultSet rs) throws SQLException;
	
	public String randomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
