package tp4.model.vo;

import java.sql.ResultSet;

public interface VirtualObject {

	// using the @rs to setup object's fields
	public abstract void map(ResultSet rs);
	
}
