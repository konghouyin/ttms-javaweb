package xupt.se.ttms.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface JDBCConnect {
	public Connection getConnection();
	public void close(Connection conn, Statement st, ResultSet rs);
}
