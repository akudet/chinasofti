package tp4.model.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * I think the the proper name is DBObject<br>
 * I don't know why it's called vo in Java<br>
 * So the name is derived from the package name<br>
 * em vo = VirtualObject
 * 
 * @author 巫金桐
 * @version 1.0
 * 
 */
public abstract class VirtualObject {
	
	final protected String parseDateTime(Timestamp date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(date.getTime()));
	}

	private static int mMagic = 1;
	private static final Map<Integer, String> mMagicTable = new HashMap<Integer, String>();

	// i think this is kind of a bad design, but for now, let it be here
	protected static int regMsg(String msg) {
		int magic = mMagic;
		mMagicTable.put(mMagic++, msg);
		return magic;
	}
	
	public static void regMsg(int magic, String msg) {
		mMagicTable.put(magic, msg);
	}

	protected String getMsg(int magic) {
		;
		return mMagicTable.get(magic);
	}

	/**
	 * using the @rs to setup object's fields
	 * 
	 * @param rs
	 *            point to a tuple which the VirtualObject represent
	 * @throws SQLException
	 */
	public abstract void map(ResultSet rs) throws SQLException;

	/**
	 * randomly generated UUID in string version with '-' stripped
	 * 
	 * @return randomly generated UUID with '-' stripped
	 */
	public String randomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * TODO : make it abstract<br>
	 * return a JSON version of the object<br>
	 * it should return sth like<br>
	 * "{'user_id' : '1000', 'username' : 'jtwu'}"
	 * 
	 * @see toXML
	 * @return a JSON version of the object
	 */
	public String toJSON() {
		return "{}";
	}

	/**
	 * TODO : make it abstract<br>
	 * return a sql version of this object<br>
	 * you can get a sql insert string like this<br>
	 * String sql = "INSERT INTO table " + obj.getValues() + ";";<br>
	 * it should return sth like<br>
	 * "VALUES('1000','jtwu')";<br>
	 * 
	 * @return a sql version of this object
	 */
	public String toValues() {
		return "VALUES()";
	}

	/**
	 * TODO : make it abstract<br>
	 * shoud return a xml version of this object<br>
	 * it should return sth like<br>
	 * &lt;USER&gt; <br>
	 * &lt;USERID&gt; 1000 &lt;USERID&gt; <br>
	 * &lt;USERNAME&gt; jtwu &lt;USERNAME&gt; <br>
	 * &lt;USER&gt; <br>
	 * this method is intend to help Servlet side programming<br>
	 * to return an VirtualObject to client user can call<br>
	 * response.getWritter().println(obj.toXML());<br>
	 * 
	 * @see toJSON
	 * @return a xml version of this object
	 */
	public String toXML() {
		return "<VirtualObject></VirtualObject>";
	}

}
