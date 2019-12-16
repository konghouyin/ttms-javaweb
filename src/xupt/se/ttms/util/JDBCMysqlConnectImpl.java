package xupt.se.ttms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;


public class JDBCMysqlConnectImpl implements JDBCConnect {
	private static String Driver = "";
	private static String URL = "";
	private static String userName = "";
	private static String password = "";
	private static DruidDataSource ds = null;
	// 阿里数据库连接池

	static {
		Properties properties = new Properties();
		try {
			//InputStream in = JDBCMysqlConnectImpl.class.getResourceAsStream("/storage.properties");
					//new FileInputStream("resource/storage.properties");
			String path = JDBCMysqlConnectImpl.class.getClassLoader().getResource("storage.properties").getPath();
            FileInputStream in = new FileInputStream(path);
			properties.load(in);
			// 文件获取和加载
		} catch (IOException e) {
			e.printStackTrace();
		}

		JDBCMysqlConnectImpl.Driver = properties.getProperty("mysql.driver");
		JDBCMysqlConnectImpl.URL = properties.getProperty("mysql.url");
		JDBCMysqlConnectImpl.userName = properties.getProperty("mysql.username");
		JDBCMysqlConnectImpl.password = properties.getProperty("mysql.password");
		// 获取key对应的value值

		ds = new DruidDataSource();
		ds.setDriverClassName(JDBCMysqlConnectImpl.Driver);
		ds.setUsername(JDBCMysqlConnectImpl.userName);
		ds.setPassword(JDBCMysqlConnectImpl.password);
		ds.setUrl(JDBCMysqlConnectImpl.URL);
		// 初始化数据库连接池
	}
	// 静态代码块，读取配置文件，为数据库连接做好准备

	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void close(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	public static void main(String[] args) {
//		System.out.println(JDBCMysqlConnectImpl.URL);
//	}
}
