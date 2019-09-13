package src.org.ccunix.record_manager.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseConnectionManager {
	static {
		// 1建立 1-建立数据库驱动程序 Driver实例对象
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {

			InputStream is = DataBaseConnectionManager.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(is);

		
		// 2连接
		return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
				properties.getProperty("pas"));
	}

	public static void close(Statement sql, Connection conn) {
		try {
			if (sql != null && !sql.isClosed()) {
				sql.close();
			}
			if (conn != null && !conn.isClosed()) {
				sql.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
