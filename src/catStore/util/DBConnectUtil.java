package catStore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnectUtil {
private static String jdbcUrl = "jdbc:sqlserver://localhost:50465;databaseName=CatStore;integratedSecurity=true;";
	
	public static Connection ConnectDB()
	{
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection =DriverManager.getConnection(jdbcUrl);
			LogFactory.getLogger().info("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}	
}
