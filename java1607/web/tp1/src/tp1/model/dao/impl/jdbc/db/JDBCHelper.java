package tp1.model.dao.impl.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp1.model.dao.Mapper;

public class JDBCHelper {

	private static <T> T execute(JDBCWork<T> work, final String query,
			final Object... params) {
		Connection conn = null;
		PreparedStatement pre = null;

		try {
			conn = DBConnection.getConnection();
			pre = conn.prepareStatement(query);

			if (null != params) {
				// setObject index start from 1
				for (int i = 1; i <= params.length; i++) {
					pre.setObject(i, params[i]);
				}
			}

			return work.execute(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != pre) {
					pre.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// should not reach here
		return null;
	}

	public static <T> List<T> executeQuery(final Mapper<T> mapper, final String query,
			final Object... params) {
		JDBCWork<List<T>> queryWork = new JDBCWork<List<T>>() {

			@Override
			public List<T> execute(PreparedStatement pre) throws SQLException {
				ResultSet rs = pre.executeQuery();
				List<T> result = new ArrayList<T>();
				while (rs.next()) {
					result.add(mapper.map(rs));
				}
				rs.close();
				return result;
			}

		};

		return execute(queryWork, query, params);
	}

	public static int executeUpdate(String query, Object... params) {
		JDBCWork<Integer> queryWork = new JDBCWork<Integer>() {

			@Override
			public Integer execute(PreparedStatement pre) throws SQLException {
				return pre.executeUpdate();
			}

		};

		return execute(queryWork, query, params);
	}

}
